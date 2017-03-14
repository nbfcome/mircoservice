/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.configurations;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
//import com.mzjf.common.consts.CustomProfiles;

//@Configuration
public class RedisConfig {

//    @Bean
//    @Profile(CustomProfiles.TEST)
//    public JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        return jedisConnectionFactory;
//    }

//    @Bean
//    @Profile(CustomProfiles.CLOUD)
//    public JedisConnectionFactory jedisSentinelConnection() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster").sentinel("127.0.0.1", 26379).sentinel("127.0.0.1", 26380);
//        return new JedisConnectionFactory(sentinelConfig);
//    }

    //    @Bean
    //    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
    //        RedisTemplate template = new RedisTemplate<String, User>();
    //        template.setConnectionFactory(jedisConnectionFactory());
    //        template.setKeySerializer(new StringRedisSerializer());
    //        template.setValueSerializer(new RedisObjectSerializer());
    //        return template;
    //    }

}
