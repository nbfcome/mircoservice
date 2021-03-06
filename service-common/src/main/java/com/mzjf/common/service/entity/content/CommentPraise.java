/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.entity.content;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @author niebiaofei
*
*/
public class CommentPraise implements Serializable {

    private static final long serialVersionUID = 295778790962405124L;

    private long id;

    private long commentId;

    private long contentId;

    private Date createTime;

    private String nickName;

    private String status;

    private Date updateTime;

    private String userIcon;

    private long userId;

    public CommentPraise() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
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

        CommentPraise other = (CommentPraise) o;

        return Objects.equals(this.getCommentId(), other.getCommentId())
                && Objects.equals(this.getContentId(), other.getContentId())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getNickName(), other.getNickName())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime())
                && Objects.equals(this.getUserIcon(), other.getUserIcon())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCommentId(), this.getContentId(), this.getCreateTime(),
                this.getNickName(), this.getStatus(), this.getUpdateTime(), this.getUserIcon(),
                this.getUserId(), this.getId());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("commentId", this.getCommentId())
                .add("contentId", this.getContentId())
                .add("createTime", this.getCreateTime())
                .add("nickName", this.getNickName())
                .add("status", this.getStatus())
                .add("updateTime", this.getUpdateTime())
                .add("userIcon", this.getUserIcon())
                .add("userId", this.getUserId())
                .add("id", this.getId())
                .toString();
    }
}