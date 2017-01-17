/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.configurations;

import org.springframework.context.annotation.Configuration;

import com.mzjf.common.configurations.DefaultSwaggerConfig;

@Configuration
public class SwaggerConfig extends DefaultSwaggerConfig {

    public String getServiceName() {
        return "temp";
    }

}
