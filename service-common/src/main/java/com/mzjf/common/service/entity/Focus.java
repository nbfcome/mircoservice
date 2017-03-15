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
public class Focus implements Serializable {

    private static final long serialVersionUID = -3168932418420814275L;

    private long userId;

    private long focusId;

    private Date createTime;

    private String status;

    private Date updateTime;

    public Focus() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFocusId() {
        return this.focusId;
    }

    public void setFocusId(long focusId) {
        this.focusId = focusId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

        Focus other = (Focus) o;

        return Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getFocusId(), other.getFocusId())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getStatus(), other.getStatus())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId(), this.getFocusId(), this.getCreateTime(),
                this.getStatus(), this.getUpdateTime());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("userId", this.getUserId())
                .add("focusId", this.getFocusId())
                .add("createTime", this.getCreateTime())
                .add("status", this.getStatus())
                .add("updateTime", this.getUpdateTime())
                .toString();
    }
}