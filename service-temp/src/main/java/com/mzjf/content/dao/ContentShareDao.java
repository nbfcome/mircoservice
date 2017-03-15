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

import com.mzjf.common.service.entity.ContentShare;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ContentShareDao {


    @Select("select id, contentId, createTime, nickName, status, userIcon, userId from contentShare where id = #{id}")
    public List<ContentShare> scan(@Param("id") Long id);

    @Insert("insert into contentShare(id, contentId, createTime, nickName, status, userIcon, userId) values (#{contentShare.id},#{contentShare.contentId},#{contentShare.createTime},#{contentShare.nickName},#{contentShare.status},#{contentShare.userIcon},#{contentShare.userId},)")
    public long add(@Param("contentShare") ContentShare contentShare);

    @Update("update contentShare set status = #{contentShare.status} where id = #{contentShare.id} ")
    public void update(@Param("contentShare") ContentShare contentShare);
}
