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

import com.mzjf.common.service.entity.content.Comment;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface CommentDao {

    @Select("select id, comment, commentedId, contentId, createTime, nickName, pics, praiseCount"
            + ", status, updateTime, userIcon, userId from comment where id = #{id}")
    public List<Comment> scan(@Param("id") Long id);

    @Insert("insert into comment(id, comment, commentedId, contentId, createTime, nickName, pics"
            + ", praiseCount, status, updateTime, userIcon, userId) "
            + "values (#{comment.id},#{comment.comment},#{comment.commentedId},#{comment.contentId}"
            + ",#{comment.createTime},#{comment.nickName},#{comment.pics},#{comment.praiseCount}"
            + ",#{comment.status},#{comment.updateTime},#{comment.userIcon},#{comment.userId},)")
    public long add(@Param("comment") Comment comment);

    @Update("update comment set status = #{comment.status} where id = #{comment.id} ")
    public void update(@Param("comment") Comment comment);

}
