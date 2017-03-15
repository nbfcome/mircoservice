/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.service.models;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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


}
