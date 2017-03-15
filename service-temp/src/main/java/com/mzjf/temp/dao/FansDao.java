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

import com.mzjf.common.service.entity.Fans;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface FansDao {

    @Select("select userId, fansId, createTime, status, updateTime from fans where id = #{id}")
    public List<Fans> scan(@Param("id") Long id);

    @Insert("insert into fans(userId, fansId, createTime, status, updateTime) values (#{fans.userId},#{fans.fansId},#{fans.createTime},#{fans.status},#{fans.updateTime},)")
    public long add(@Param("fans") Fans fans);

    @Update("update fans set status = #{fans.status} where id = #{fans.id} ")
    public void update(@Param("fans") Fans fans);
}
