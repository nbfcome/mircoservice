/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.service.models.builders.user;

import com.mzjf.common.service.models.user.UserModel;

/**
 * @author niebiaofei
 *
 */
public class UserBuilder {
    private String babyName;

    private String birthDay;

    private String city;

    private String icon;

    private String loginType;

    private String mobile;

    private String nickName;

    private String province;

    public UserBuilder babyName(String babyName) {
        this.babyName = babyName;
        return this;
    }

    public UserBuilder birthDay(String birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public UserBuilder city(String city) {
        this.city = city;
        return this;
    }

    public UserBuilder icon(String icon) {
        this.icon = icon;
        return this;
    }

    public UserBuilder loginType(String loginType) {
        this.loginType = loginType;
        return this;
    }

    public UserBuilder mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public UserBuilder nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public UserBuilder province(String province) {
        this.province = province;
        return this;
    }

    public UserModel build() {
        UserModel result = new UserModel();
        result.setBabyName(this.babyName);
        result.setBirthDay(this.birthDay);
        result.setCity(this.city);
        result.setIcon(this.icon);
        result.setLoginType(this.loginType);
        result.setMobile(this.mobile);
        result.setNickName(this.nickName);
        result.setProvince(this.province);
        return result;
    }

    public static UserModel createTestModel() {
        return new UserBuilder()
                .babyName("nbf")
                .birthDay("nbf")
                .city("nbf")
                .icon("nbf")
                .loginType("nbf")
                .mobile("nbf")
                .nickName("nbf")
                .province("nbf")
                .build();
    }



}
