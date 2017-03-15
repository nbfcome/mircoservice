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

import com.mzjf.common.service.entity.Content;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface ContentDao {


    @Select("select id, city, collectionCount, commentCount, content, country, createTime, nickName, pics, praiseCount, province, shareCount, status, updateTime, userIcon, userId from content where id = #{id}")
    public List<Content> scan(@Param("id") Long id);

    @Insert("insert into content(id, city, collectionCount, commentCount, content, country, createTime, nickName, pics, praiseCount, province, shareCount, status, updateTime, userIcon, userId) values (#{content.id},#{content.city},#{content.collectionCount},#{content.commentCount},#{content.content},#{content.country},#{content.createTime},#{content.nickName},#{content.pics},#{content.praiseCount},#{content.province},#{content.shareCount},#{content.status},#{content.updateTime},#{content.userIcon},#{content.userId},)")
    public long add(@Param("content") Content content);

    @Update("update content set status = #{content.status} where id = #{content.id} ")
    public void update(@Param("content") Content content);
}
