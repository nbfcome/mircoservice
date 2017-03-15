/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.models.builders.content;

import java.util.List;

import com.mzjf.common.service.models.content.ContentModel;


/**
* @author niebiaofei
*
*/
public class ContentBuilder {

    private List<String> pics;

    private Long content;

    private String city;

    private String province;

    private String country;
    
    public ContentBuilder pics(List<String> pics) {
        this.pics = pics;
        return this;
    }

    public ContentBuilder content(Long content) {
        this.content = content;
        return this;
    }

    public ContentBuilder city(String city) {
        this.city = city;
        return this;
    }

    public ContentBuilder province(String province) {
        this.province = province;
        return this;
    }

    public ContentBuilder country(String country) {
        this.country = country;
        return this;
    }

    public ContentModel build() {
        ContentModel result = new ContentModel();
        result.setPics(this.pics);
        result.setContent(this.content);
        result.setCity(this.city);
        result.setProvince(this.province);
        result.setCountry(this.country);
        return result;
    }

}