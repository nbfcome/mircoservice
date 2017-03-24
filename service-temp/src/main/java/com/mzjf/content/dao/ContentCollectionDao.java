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

import com.mzjf.common.service.entity.content.ContentCollection;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ContentCollectionDao {

    @Select("select id, contentId, createTime, nickName, status, updateTime, userIcon, userId from contentCollection where id = #{id}")
    public List<ContentCollection> scan(@Param("id") Long id);

    @Insert("insert into contentCollection(id, contentId, createTime, nickName, status, updateTime, userIcon, userId) values (#{contentCollection.id},#{contentCollection.contentId},#{contentCollection.createTime},#{contentCollection.nickName},#{contentCollection.status},#{contentCollection.updateTime},#{contentCollection.userIcon},#{contentCollection.userId},)")
    public long add(@Param("contentCollection") ContentCollection contentCollection);

    @Update("update contentCollection set status = #{contentCollection.status} where id = #{contentCollection.id} ")
    public void update(@Param("contentCollection") ContentCollection contentCollection);
}
