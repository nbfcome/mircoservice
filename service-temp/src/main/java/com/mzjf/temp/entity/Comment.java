/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.temp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @author niebiaofei
*
*/
public class Comment implements Serializable {

    private static final long serialVersionUID = 3705244616781753918L;

    private long id;

    private String comment;

    private long commentedId;

    private long contentId;

    private Date createTime;

    private String nickName;

    private String pics;

    private long praiseCount;

    private String status;

    private Date updateTime;

    private String userIcon;

    private long userId;

    public Comment() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCommentedId() {
        return this.commentedId;
    }

    public void setCommentedId(long commentedId) {
        this.commentedId = commentedId;
    }

    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
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

        Comment other = (Comment) o;

        return Objects.equals(this.getComment(), other.getComment())
                && Objects.equals(this.getCommentedId(), other.getCommentedId())
                && Objects.equals(this.getContentId(), other.getContentId())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getNickName(), other.getNickName())
                && Objects.equals(this.getPics(), other.getPics())
                && Objects.equals(this.getPraiseCount(), other.getPraiseCount())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime())
                && Objects.equals(this.getUserIcon(), other.getUserIcon())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getComment(), this.getCommentedId(), this.getContentId(),
                this.getCreateTime(), this.getNickName(), this.getPics(), this.getPraiseCount(),
                this.getStatus(), this.getUpdateTime(), this.getUserIcon(), this.getUserId(),
                this.getId());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("comment", this.getComment())
                .add("commentedId", this.getCommentedId())
                .add("contentId", this.getContentId())
                .add("createTime", this.getCreateTime())
                .add("nickName", this.getNickName())
                .add("pics", this.getPics())
                .add("praiseCount", this.getPraiseCount())
                .add("status", this.getStatus())
                .add("updateTime", this.getUpdateTime())
                .add("userIcon", this.getUserIcon())
                .add("userId", this.getUserId())
                .add("id", this.getId())
                .toString();
    }
}