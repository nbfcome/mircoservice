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
public class Score implements Serializable {

    private static final long serialVersionUID = -1295363901707866710L;

    private long userId;

    private long count;

    private Date createTime;

    private Date updateTime;

    public Score() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

        Score other = (Score) o;

        return Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getCount(), other.getCount())
                && Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getUpdateTime(), other.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId(), this.getCount(), this.getCreateTime(),
                this.getUpdateTime());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("userId", this.getUserId())
                .add("count", this.getCount())
                .add("createTime", this.getCreateTime())
                .add("updateTime", this.getUpdateTime())
                .toString();
    }
}