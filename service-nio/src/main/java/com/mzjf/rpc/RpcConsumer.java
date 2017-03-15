package com.mzjf.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RpcFrameWork.class);

    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        maps.stream().forEach(t -> map.put((String) t.get(""), t.get("")));
        HelloService service = RpcFrameWork.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World" + i);
            logger.info(hello);
            Thread.sleep(1000);
        }
    }
}
