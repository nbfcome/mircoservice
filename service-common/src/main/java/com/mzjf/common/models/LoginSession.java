/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Login session for mifit
 */
public class LoginSession {

    @JsonProperty("userid")
    private String userId;

    @JsonProperty("sessionid")
    private String sessionId;

    @JsonProperty("login_time")
    private long loginTime;

    @JsonProperty("last_verify_time")
    private long lastVerifyTime;

    @JsonProperty("device_type")
    private String deviceType;

    @JsonProperty("client_version")
    private String clientVersion;

    @JsonProperty("appname")
    private String appname;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("expire_in")
    private long expireIn;

    @JsonProperty("status")
    private short status;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginSession other = (LoginSession) o;

        return Objects.equals(this.getAppname(), other.getAppname())
                && Objects.equals(this.getClientVersion(), other.getClientVersion())
                && Objects.equals(this.getDeviceType(), other.getDeviceType())
                && Objects.equals(this.getExpireIn(), other.getExpireIn())
                && Objects.equals(this.getIp(), other.getIp())
                && Objects.equals(this.getLastVerifyTime(), other.getLastVerifyTime())
                && Objects.equals(this.getLoginTime(), other.getLoginTime())
                && Objects.equals(this.getSessionId(), other.getSessionId())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUserId(), other.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getAppname(),
                this.getClientVersion(),
                this.getDeviceType(),
                this.getExpireIn(),
                this.getIp(),
                this.getLastVerifyTime(),
                this.getLoginTime(),
                this.getSessionId(),
                this.getStatus(),
                this.getUserId());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("appname", this.getAppname()).add("userid", this.getUserId())
                .add("client_version", this.getClientVersion())
                .add("device_type", this.getDeviceType()).add("expire_in", this.getExpireIn())
                .add("ip", this.getIp()).add("last_verify_time", this.getLastVerifyTime())
                .add("login_time", this.getLoginTime()).add("sessionid", this.getSessionId())
                .add("status", this.getStatus()).toString();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public long getLastVerifyTime() {
        return this.lastVerifyTime;
    }

    public void setLastVerifyTime(long lastVerifyTime) {
        this.lastVerifyTime = lastVerifyTime;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getExpireIn() {
        return this.expireIn;
    }

    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }

    public short getStatus() {
        return this.status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

}
