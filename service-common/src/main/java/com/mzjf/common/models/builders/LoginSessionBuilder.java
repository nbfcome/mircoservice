/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models.builders;

import com.mzjf.common.models.LoginSession;
import com.mzjf.common.utils.JsonUtils;


public class LoginSessionBuilder {

    private LoginSession session;

    public LoginSessionBuilder() {
        this.session = new LoginSession();
    }

    public LoginSessionBuilder userId(String userId) {
        this.session.setUserId(userId);
        return this;
    }

    public LoginSessionBuilder sessionId(String sessionId) {
        this.session.setSessionId(sessionId);
        return this;
    }

    public LoginSessionBuilder loginTime(long loginTime) {
        this.session.setLoginTime(loginTime);
        return this;
    }

    public LoginSessionBuilder lastVerifyTime(long lastVerifyTime) {
        this.session.setLastVerifyTime(lastVerifyTime);
        return this;
    }

    public LoginSessionBuilder deviceType(String deviceType) {
        this.session.setDeviceType(deviceType);
        return this;
    }

    public LoginSessionBuilder clientVersion(String clientVersion) {
        this.session.setClientVersion(clientVersion);
        return this;
    }

    public LoginSessionBuilder appname(String appname) {
        this.session.setAppname(appname);
        return this;
    }

    public LoginSessionBuilder ip(String ip) {
        this.session.setIp(ip);
        return this;
    }

    public LoginSessionBuilder expireIn(long expireIn) {
        this.session.setExpireIn(expireIn);
        return this;
    }

    public LoginSessionBuilder status(short status) {
        this.session.setStatus(status);
        return this;
    }

    public LoginSession build() {
        return this.session;
    }

    public static LoginSession build(String data) {
        return JsonUtils.deserialize(data, LoginSession.class);
    }

    public static LoginSession createTestModel() {
        LoginSessionBuilder builder = new LoginSessionBuilder();
        builder.appname("mifit")
                .clientVersion("2.1.1.1")
                .deviceType("device")
                .expireIn(77760000L)
                .ip("192.168.0.1")
                .lastVerifyTime(1459847365L)
                .loginTime(1459847365L)
                .sessionId("14A59F58-233D-0A55-7E98-B3C61B1C81F3")
                .status((short) 1)
                .userId("690559145");

        return builder.build();
    }
}
