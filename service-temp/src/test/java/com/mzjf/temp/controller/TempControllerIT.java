/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.controller;

import static org.junit.Assert.assertNotNull;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.mzjf.TempApplication;
import com.mzjf.common.service.models.UserSpec;

/**
 * Tests {@link TempController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TempApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class TempControllerIT {
    @Value("${local.server.port}")
    private String port;

    private Integer userId;
    private MultiValueMap<String, String> map;
    private TestRestTemplate template;
    @Autowired
    private JedisConnectionFactory JedisConnection;

    @Before
    public void setUp() throws Exception {
        this.userId = 11;
        this.map = new LinkedMultiValueMap<>();
        this.map.add("tokenId", "1111");
        this.template = new TestRestTemplate();
    }

    /**
     * Tests {@link TempController#get(Long)}.
     */
    @Test
    public void testGet() throws Exception {
        System.err.println("nbf" + this.port);
        HttpEntity<Object> requestEntityGet = new HttpEntity<Object>(this.map);

        ResponseEntity<UserSpec> responseGet = this.template.exchange(
                "http://localhost:" + this.port + "/users/" + this.userId.toString(),
                HttpMethod.GET,
                requestEntityGet, UserSpec.class);

        Assert.assertThat(responseGet.getStatusCode(), Matchers.is(HttpStatus.OK));
        UserSpec resultGet = responseGet.getBody();
        assertNotNull(resultGet);
        Assert.assertThat("zhangsan", Matchers.is(resultGet.getName()));
    }
    
    @Test
    public void testRedis() throws Exception {
        this.JedisConnection.getConnection().set("nbf".getBytes(), "123".getBytes());
        String result = new String(this.JedisConnection.getConnection().get("nbf".getBytes()));
        Assert.assertThat("123", Matchers.is(result));
    }

}
