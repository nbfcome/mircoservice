/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mzjf.common.service.entity.UserEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "fallbackGetEntity")
    public UserEntity getEntity(Long id) {
        System.err.println("service-user" + "/users/" + id);
        return this.restTemplate.getForObject("http://service-user/users/" + id, UserEntity.class);
    }

    public UserEntity fallbackGetEntity(Long id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(0L);
        userEntity.setName("fallback");
        return userEntity;
    }

    public String serviceUrl() {
        List<ServiceInstance> list = this.discoveryClient.getInstances("service-user");
        if (list != null && list.size() > 0) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
}
