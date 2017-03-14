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

import com.mzjf.temp.entity.Comment;

@Mapper
public interface CommentDao {

    @Select("select * from comment where id = #{id}")
    public List<Comment> getCommentById(@Param("id") Long id);

    @Insert("insert into comment(name) values (#{comment.name})")
    public long add(@Param("comment") Comment comment);

    @Update("update comment set status = #{comment.status} where id = #{comment.id} ")
    public void update(@Param("comment") Comment comment);

}
