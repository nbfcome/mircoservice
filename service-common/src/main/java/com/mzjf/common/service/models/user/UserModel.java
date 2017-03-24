/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.service.models.user;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author niebiaofei
 *
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    @ApiModelProperty(value = "Baby's name", required = true)
    @JsonProperty
    @NotNull
    private String babyName;

    @ApiModelProperty(value = "User's birthDay", required = true)
    @JsonProperty
    @NotNull
    private String birthDay;

    @ApiModelProperty(value = "Live in city by the user", required = true)
    @JsonProperty
    @NotNull
    private String city;

    @ApiModelProperty(value = "User's icon", required = true)
    @JsonProperty
    @NotNull
    private String icon;

    @ApiModelProperty(value = "User's login type", required = true)
    @JsonProperty
    @NotNull
    private String loginType;

    @ApiModelProperty(value = "User's mobile", required = true)
    @JsonProperty
    @NotNull
    private String mobile;

    @ApiModelProperty(value = "User's nickname", required = true)
    @JsonProperty
    @NotNull
    private String nickName;

    @ApiModelProperty(value = "Live in provice by the user", required = true)
    @JsonProperty
    @NotNull
    private String province;

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
