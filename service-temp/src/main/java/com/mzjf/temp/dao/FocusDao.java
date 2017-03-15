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

import com.mzjf.common.service.entity.Focus;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface FocusDao {

    @Select("select userId, focusId, createTime, status, updateTime from focus where id = #{id}")
    public List<Focus> scan(@Param("id") Long id);

    @Insert("insert into focus(userId, focusId, createTime, status, updateTime) values (#{focus.userId},#{focus.focusId},#{focus.createTime},#{focus.status},#{focus.updateTime},)")
    public long add(@Param("focus") Focus focus);

    @Update("update focus set status = #{focus.status} where id = #{focus.id} ")
    public void update(@Param("focus") Focus focus);
}
