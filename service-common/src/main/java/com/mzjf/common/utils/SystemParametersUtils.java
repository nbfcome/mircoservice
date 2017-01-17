/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class SystemParametersUtils {

    public static final String APP_NAME = "appName";

    public static final String APP_TOKEN = "appToken";

    public static final String CALL_ID = "callId";

    public static final String USER_ID = "userId";

    public static final String COUNTRY = "country";

    public static final String TIMEZONE = "timezone";

    public static final String CHANNEL = "channel";

    public static final String APP_PLATFORM = "appPlatform";

    public static final String MIFIT_APP_PLATFORM = "appplatform";

    public static final String CV = "cv";

    public static final String V = "v";

    public static final String LANG = "lang";

    public static final String LEGACY = "LEGACY";

    public static final String IP = "IP";

    public static final String THIRD_NAME = "thirdName";

    public static final String SECURITY = "security";

    public static final List<String> KEYS = ImmutableList.of(APP_NAME, APP_TOKEN, CALL_ID,
            USER_ID, COUNTRY, TIMEZONE, CHANNEL, APP_PLATFORM, CV, V, LANG, LEGACY, SECURITY, MIFIT_APP_PLATFORM);

    private static final Logger logger = LoggerFactory.getLogger(SystemParametersUtils.class);

    public static void createSystemParameters(HttpServletRequest httpRequest) {
        for (String key : SystemParametersUtils.KEYS) {
            MDC.remove(key);
            String headerValue = httpRequest.getHeader(key);
            if (headerValue != null) {
                MDC.put(key, headerValue);
            }
        }
        MDC.put(SystemParametersUtils.IP, getIP(httpRequest));
    }

    public static void createOrUpdateSystemParameters(Map<String, String> parameters) {
        logger.info("parameters {}", parameters);
        if (parameters == null) {
            return;
        }
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            MDC.put(entry.getKey(),
                    Preconditions.checkNotNull(entry.getValue()));
        }
    }

    public static boolean isLegacyAPI() {
        boolean isLegacyAPI = "true".equalsIgnoreCase(MDC.get(LEGACY));
        logger.info("isLegacyAPI {}", isLegacyAPI);
        return isLegacyAPI;
    }

    public static String getAppName() {
        return MDC.get(APP_NAME);
    }

    public static void setAppName(String appName) {
        MDC.put(APP_NAME, appName);
    }

    public static String getAppToken() {
        return MDC.get(APP_TOKEN);
    }

    public static void setAppToken(String appToken) {
        MDC.put(APP_TOKEN, appToken);
    }

    public static String getUserId() {
        return MDC.get(USER_ID);
    }

    public static void setUserId(String userId) {
        MDC.put(USER_ID, userId);
    }

    public static String getTimeZone() {
        return MDC.get(TIMEZONE);
    }

    public static void setTimeZone(String timezone) {
        MDC.put(TIMEZONE, timezone);
    }

    public static void setThirdName(String thirdName) {
        MDC.put(THIRD_NAME, thirdName);
    }

    public static String getSecurity() {
        return MDC.get(SECURITY);
    }

    public static void setSecurity(String security) {
        MDC.put(SECURITY, security);
    }

    public static String getApplicationPlatform() {
        return MDC.get(APP_PLATFORM);
    }

    public static void setApplicationPlatform(String appPlatform) {
        MDC.put(APP_PLATFORM, appPlatform);
    }

    public static String getMifitAppPlatform() {
        return MDC.get(MIFIT_APP_PLATFORM);
    }

    public static void setMifitAppPlatform(String appPlatform) {
        MDC.put(MIFIT_APP_PLATFORM, appPlatform);
    }


    public static String getLanguage() {
        return MDC.get(LANG);
    }

    public static String getThirdName() {
        return MDC.get(THIRD_NAME);
    }

    public static String getClientIp() {
        return MDC.get(IP);
    }

    public static void setLanguage(String language) {
        MDC.put(LANG, language);
    }

    public static String getCountry() {
        return MDC.get(COUNTRY);
    }

    public static void setCountry(String country) {
        MDC.put(COUNTRY, country);
    }

    private static String getIP(HttpServletRequest req) {
        String xForwardedFor = req.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(xForwardedFor)) {
            return req.getRemoteAddr();
        }
        int n = xForwardedFor.indexOf(',');
        if (n <= 0) {
            return xForwardedFor;
        }
        return xForwardedFor.substring(0, n);
    }
}
