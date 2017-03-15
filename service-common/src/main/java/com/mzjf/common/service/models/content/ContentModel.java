/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.models.content;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
* @author niebiaofei
*
*/
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentModel {

    @ApiModelProperty(value = "content's pics", required = true)
    @JsonProperty
    @NotNull
    private List<String> pics;

    @ApiModelProperty(value = "User's content", required = true)
    @JsonProperty
    @NotNull
    private Long content;

    @ApiModelProperty(value = "Live in city by the user", required = true)
    @JsonProperty
    @NotNull
    private String city;

    @ApiModelProperty(value = "Live in province by the user", required = true)
    @JsonProperty
    @NotNull
    private String province;

    @ApiModelProperty(value = "Live in country by the user", required = true)
    @JsonProperty
    @NotNull
    private String country;

    public ContentModel() {
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getContent() {
        return this.content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getPics() {
        return this.pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ContentModel other = (ContentModel) o;

        return Objects.equals(this.getCity(), other.getCity())
                && Objects.equals(this.getPics(), other.getPics())
                && Objects.equals(this.getProvince(), other.getProvince())
                && Objects.equals(this.getContent(), other.getContent())
                && Objects.equals(this.getCountry(), other.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCity(),
                this.getPics(),
                this.getProvince(),
                this.getContent(),
                this.getCountry());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("city", this.getCity())
                .add("pics", this.getPics())
                .add("province", this.getProvince())
                .add("content", this.getContent())
                .add("country", this.getCountry())
                .toString();
    }

}