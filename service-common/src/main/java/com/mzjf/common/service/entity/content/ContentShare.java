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
public class ContentShare implements Serializable {

    private static final long serialVersionUID = 4513015571775283814L;

    private long id;

    private long contentId;

    private Date createTime;

    private String nickName;

    private String status;

    private String userIcon;

    private long userId;

    public ContentShare() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

        ContentShare other = (ContentShare) o;

        return Objects.equals(this.getContentId(), other.getContentId())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getNickName(), other.getNickName())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUserIcon(), other.getUserIcon())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getContentId(), this.getCreateTime(), this.getNickName(),
                this.getStatus(), this.getUserIcon(), this.getUserId(), this.getId());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("contentId", this.getContentId())
                .add("createTime", this.getCreateTime())
                .add("nickName", this.getNickName())
                .add("status", this.getStatus())
                .add("userIcon", this.getUserIcon())
                .add("userId", this.getUserId())
                .add("id", this.getId())
                .toString();
    }
}