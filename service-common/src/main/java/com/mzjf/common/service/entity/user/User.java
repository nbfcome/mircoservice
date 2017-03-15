/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.entity.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @author niebiaofei
*
*/
public class User implements Serializable {

    private static final long serialVersionUID = -4658599734144648639L;

    private long userId;

    private String babyName;

    private String birthDay;

    private String city;

    private Date createTime;

    private String icon;

    private String loginType;

    private String mobile;

    private String nickName;

    private String province;

    private String status;

    private Date updateTime;

    public User() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getBabyName() {
        return this.babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User other = (User) o;

        return Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getIcon(), other.getIcon())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getBabyName(), other.getBabyName())
                && Objects.equals(this.getBirthDay(), other.getBirthDay())
                && Objects.equals(this.getCity(), other.getCity())
                && Objects.equals(this.getLoginType(), other.getLoginType())
                && Objects.equals(this.getMobile(), other.getMobile())
                && Objects.equals(this.getNickName(), other.getNickName())
                && Objects.equals(this.getProvince(), other.getProvince())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCreateTime(), this.getIcon(), this.getUserId(),
                this.getBabyName(), this.getBirthDay(), this.getCity(), this.getLoginType(),
                this.getMobile(), this.getNickName(), this.getProvince(), this.getStatus(),
                this.getUpdateTime());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("createTime", this.getCreateTime())
                .add("icon", this.getIcon())
                .add("userId", this.getUserId())
                .add("babyName", this.getBabyName())
                .add("birthDay", this.getBirthDay())
                .add("city", this.getCity())
                .add("loginType", this.getLoginType())
                .add("mobile", this.getMobile())
                .add("nickName", this.getNickName())
                .add("province", this.getProvince())
                .add("status", this.getStatus())
                .add("updateTime", this.getUpdateTime())
                .toString();
    }
}