/*
 * Copyright (c) 2017-2018 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.content.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mzjf.common.service.entity.content.ContentPraise;


/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ContentPraiseDao {

    @Select("select id, contentId, createTime, nickName, status, updateTime, userIcon, userId from contentPraise where id = #{id}")
    public List<ContentPraise> scan(@Param("id") Long id);

    @Insert("insert into contentPraise(id, contentId, createTime, nickName, status, updateTime, userIcon, userId) values (#{contentPraise.id},#{contentPraise.contentId},#{contentPraise.createTime},#{contentPraise.nickName},#{contentPraise.status},#{contentPraise.updateTime},#{contentPraise.userIcon},#{contentPraise.userId},)")
    public long add(@Param("contentPraise") ContentPraise contentPraise);

    @Update("update contentPraise set status = #{contentPraise.status} where id = #{contentPraise.id} ")
    public void update(@Param("contentPraise") ContentPraise contentPraise);
}
