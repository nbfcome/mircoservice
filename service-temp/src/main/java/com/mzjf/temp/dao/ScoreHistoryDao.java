/*
 * Copyright (c) 2017-2018 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mzjf.common.service.entity.ScoreHistory;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ScoreHistoryDao {

    @Select("select id, createTime, score, type, userId from scoreHistory where id = #{id}")
    public List<ScoreHistory> scan(@Param("id") Long id);

    @Insert("insert into scoreHistory(id, createTime, score, type, userId) values (#{scoreHistory.id},#{scoreHistory.createTime},#{scoreHistory.score},#{scoreHistory.type},#{scoreHistory.userId},)")
    public long add(@Param("scoreHistory") ScoreHistory scoreHistory);

    @Update("update scoreHistory set status = #{scoreHistory.status} where id = #{scoreHistory.id} ")
    public void update(@Param("scoreHistory") ScoreHistory scoreHistory);
}
