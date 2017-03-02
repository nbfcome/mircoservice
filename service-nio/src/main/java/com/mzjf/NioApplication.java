/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class NioApplication {
    public static void main(String[] args) {
        SpringApplication.run(NioApplication.class, args);

    }

}