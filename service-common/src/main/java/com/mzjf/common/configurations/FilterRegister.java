/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.configurations;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mzjf.common.consts.CustomProfiles;
import com.mzjf.common.filters.HystrixRequestContextFilter;
import com.mzjf.common.filters.LogFilter;
import com.mzjf.common.filters.RequestBodyLoggingFilter;

// NOTE: Filter registration is NOT necessary, until we need to specify some behaviors like UrlPatterns. Spring boot looks up for
// all beans annotated with @Component of sub-type filter. For example, even if we don't add function registerRequestBodyLoggingFilterBean(),
// RequestBodyLoggingFilter will still be mapped and loaded.
@Configuration
public class FilterRegister {

    @Bean
    public FilterRegistrationBean registerHystrixRequestContextFilterBean(
            HystrixRequestContextFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setOrder(0);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean registerLogFilterBean(LogFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    @Profile(CustomProfiles.VERBOSE_LOGGING)
    public FilterRegistrationBean registerRequestBodyLoggingFilterBean(
            RequestBodyLoggingFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setOrder(4);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
