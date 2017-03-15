package com.mzjf.rpc;

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFrameWork.export(service, 1234);
    }

}
