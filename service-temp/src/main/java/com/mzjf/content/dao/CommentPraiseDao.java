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

import com.mzjf.common.service.entity.CommentPraise;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface CommentPraiseDao {

    @Select("select id, commentId, contentId, createTime, nickName, status, updateTime, userIcon, userId from commentPraise where id = #{id}")
    public List<CommentPraise> scan(@Param("id") Long id);

    @Insert("insert into commentPraise(id, commentId, contentId, createTime, nickName, status, updateTime, userIcon, userId) values (#{commentPraise.id},#{commentPraise.commentId},#{commentPraise.contentId},#{commentPraise.createTime},#{commentPraise.nickName},#{commentPraise.status},#{commentPraise.updateTime},#{commentPraise.userIcon},#{commentPraise.userId},)")
    public long add(@Param("commentPraise") CommentPraise commentPraise);

    @Update("update commentPraise set status = #{commentPraise.status} where id = #{commentPraise.id} ")
    public void update(@Param("commentPraise") CommentPraise commentPraise);

}
