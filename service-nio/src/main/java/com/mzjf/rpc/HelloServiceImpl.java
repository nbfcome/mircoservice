package com.mzjf.rpc;

public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String msg) {
        return "Come from mar's service: " + msg;
    }

}
