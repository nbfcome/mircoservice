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

import com.mzjf.common.service.entity.Score;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ScoreDao {

    @Select("select userId, count, createTime, updateTime from score where id = #{id}")
    public List<Score> scan(@Param("id") Long id);

    @Insert("insert into score(userId, count, createTime, updateTime) values (#{score.userId},#{score.count},#{score.createTime},#{score.updateTime},)")
    public long add(@Param("score") Score score);

    @Update("update score set status = #{score.status} where id = #{score.id} ")
    public void update(@Param("score") Score score);
}
