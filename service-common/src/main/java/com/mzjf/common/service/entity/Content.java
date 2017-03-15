/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @author niebiaofei
*
*/
public class Content implements Serializable {

    private static final long serialVersionUID = 1971424540444681176L;

    private long id;

    private String city;

    private long collectionCount;

    private long commentCount;

    private String content;

    private String country;

    private Date createTime;

    private String nickName;

    private String pics;

    private long praiseCount;

    private String province;

    private long shareCount;

    private String status;

    private Date updateTime;

    private String userIcon;

    private long userId;

    public Content() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getCollectionCount() {
        return this.collectionCount;
    }

    public void setCollectionCount(long collectionCount) {
        this.collectionCount = collectionCount;
    }

    public long getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPics() {
        return this.pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public long getPraiseCount() {
        return this.praiseCount;
    }

    public void setPraiseCount(long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getShareCount() {
        return this.shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
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

    public String getUserIcon() {
        return this.userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Content other = (Content) o;

        return Objects.equals(this.getCity(), other.getCity())
                && Objects.equals(this.getCollectionCount(), other.getCollectionCount())
                && Objects.equals(this.getCommentCount(), other.getCommentCount())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getNickName(), other.getNickName())
                && Objects.equals(this.getPics(), other.getPics())
                && Objects.equals(this.getPraiseCount(), other.getPraiseCount())
                && Objects.equals(this.getProvince(), other.getProvince())
                && Objects.equals(this.getShareCount(), other.getShareCount())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime())
                && Objects.equals(this.getUserIcon(), other.getUserIcon())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getId(), other.getId())
                && Objects.equals(this.getContent(), other.getContent())
                && Objects.equals(this.getCountry(), other.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCity(), this.getCollectionCount(), this.getCommentCount(),
                this.getCreateTime(), this.getNickName(), this.getPics(), this.getPraiseCount(),
                this.getProvince(), this.getShareCount(), this.getStatus(), this.getUpdateTime(),
                this.getUserIcon(), this.getUserId(), this.getId(), this.getContent(),
                this.getCountry());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("city", this.getCity())
                .add("collectionCount", this.getCollectionCount())
                .add("commentCount", this.getCommentCount())
                .add("createTime", this.getCreateTime())
                .add("nickName", this.getNickName())
                .add("pics", this.getPics())
                .add("praiseCount", this.getPraiseCount())
                .add("province", this.getProvince())
                .add("shareCount", this.getShareCount())
                .add("status", this.getStatus())
                .add("updateTime", this.getUpdateTime())
                .add("userIcon", this.getUserIcon())
                .add("userId", this.getUserId())
                .add("id", this.getId())
                .add("content", this.getContent())
                .add("country", this.getCountry())
                .toString();
    }
}