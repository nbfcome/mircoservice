/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.service.entity.score;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @author niebiaofei
*
*/
public class ScoreHistory implements Serializable {

    private static final long serialVersionUID = 7514722093764985603L;

    private long id;

    private Date createTime;

    private long score;

    private String type;

    private long userId;

    public ScoreHistory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getScore() {
        return this.score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

        ScoreHistory other = (ScoreHistory) o;

        return Objects.equals(this.getCreateTime(), other.getCreateTime())
                && Objects.equals(this.getScore(), other.getScore())
                && Objects.equals(this.getUserId(), other.getUserId())
                && Objects.equals(this.getId(), other.getId())
                && Objects.equals(this.getType(), other.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCreateTime(), this.getScore(), this.getUserId(), this.getId(),
                this.getType());
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("createTime", this.getCreateTime())
                .add("score", this.getScore())
                .add("userId", this.getUserId())
                .add("id", this.getId())
                .add("type", this.getType())
                .toString();
    }
}