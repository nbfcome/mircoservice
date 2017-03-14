package com.mzjf.nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadNIOEchoServer {
    public static Map<Socket, Long> GEYM_TIME_STAT = new HashMap<Socket, Long>();

    class EchoClient {
        private LinkedList<ByteBuffer> linkedList;

        EchoClient() {
            this.linkedList = new LinkedList<ByteBuffer>();
        }

        public LinkedList<ByteBuffer> getOutputQueue() {
            return this.linkedList;
        }

        public void enqueue(ByteBuffer bb) {
            this.linkedList.addFirst(bb);
        }
    }

    class HandleMsg implements Runnable {
        private SelectionKey selectionKey;
        private ByteBuffer byteBuffer;

        public HandleMsg(SelectionKey selectionKey, ByteBuffer byteBuffer) {
            super();
            this.selectionKey = selectionKey;
            this.byteBuffer = byteBuffer;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) this.selectionKey.attachment();
            echoClient.enqueue(this.byteBuffer);
            this.selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }

    }

    private Selector selector;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    private void startServer() throws Exception {
        this.selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8000));
        // 注册感兴趣的事件，此处对accpet事件感兴趣
        serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        for (;;) {
            this.selector.select();
            Set<?> readyKeys = this.selector.selectedKeys();
            Iterator<?> iterator = readyKeys.iterator();
            long e = 0;
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    doAccept(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    if (!GEYM_TIME_STAT.containsKey(((SocketChannel) selectionKey
                            .channel()).socket())) {
                        GEYM_TIME_STAT.put(
                                ((SocketChannel) selectionKey.channel()).socket(),
                                System.currentTimeMillis());
                    }
                    doRead(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isWritable()) {
                    doWrite(selectionKey);
                    e = System.currentTimeMillis();
                    long b = GEYM_TIME_STAT.remove(((SocketChannel) selectionKey
                            .channel()).socket());
                    System.out.println("spend:" + (e - b) + "ms");
                }
            }
        }
    }

    private void doWrite(SelectionKey selectionKey) {
        System.err.println("dowrite");
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        EchoClient echoClient = (EchoClient) selectionKey.attachment();
        LinkedList<ByteBuffer> linkedList = echoClient.getOutputQueue();
        ByteBuffer byteBuffer = linkedList.getLast();
        try {
            int len = channel.write(byteBuffer);
            if (len == -1) {
                disconnect(selectionKey);
                return;
            }
            if (byteBuffer.remaining() == 0) {
                linkedList.removeLast();
            }
        } catch (Exception e) {
            disconnect(selectionKey);
        }
        if (linkedList.size() == 0) {
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }

    private void doRead(SelectionKey selectionKey) {
        System.err.println("doread");
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
        int len;
        try {
            len = channel.read(byteBuffer);
            if (len < 0) {
                disconnect(selectionKey);
                return;
            }
        } catch (Exception e) {
            disconnect(selectionKey);
            return;
        }
        byteBuffer.flip();
        this.executorService.execute(new HandleMsg(selectionKey, byteBuffer));
    }

    private void disconnect(SelectionKey sk) {
        //省略略干关闭操作
    }

    private void doAccept(SelectionKey selectionKey) {
        System.err.println("doaccept");
        SocketChannel socketChannel;
        try {
            socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
            socketChannel.configureBlocking(false);
            SelectionKey selectionKey1 = socketChannel.register(selector,
                    SelectionKey.OP_READ);
            EchoClient echoClinet = new EchoClient();
            selectionKey1.attach(echoClinet);
            System.out.println("Accepted connection from "
                    + socketChannel.socket().getInetAddress().getHostAddress());
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        MultiThreadNIOEchoServer echoServer = new MultiThreadNIOEchoServer();
        try {
            echoServer.startServer();
        } catch (Exception e) {
        }

    }

}
