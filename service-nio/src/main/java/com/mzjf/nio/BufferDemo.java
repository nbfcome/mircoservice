package com.mzjf.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 得到Channel 2.申请Buffer 3. 建立Channel和Buffer的读/写关系 4. 关闭 
 *
 */
public class BufferDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(
                "/home/nbfcome/soft/spark-1.4.0-bin-hadoop2.4/README.md"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        System.err.println("limit=" + byteBuffer.limit() + " capacity=" + byteBuffer.capacity()
                + " position=" + byteBuffer.position() + "mark=" + byteBuffer.mark());
        fileChannel.close();
        byteBuffer.flip();

        if (fileInputStream != null) {
            fileInputStream.close();
        }
        System.err.print("buffer process finshing ....");
    }
}
