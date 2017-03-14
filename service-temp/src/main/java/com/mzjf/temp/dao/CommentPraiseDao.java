/*
 * Copyright (c) 2017-2018 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.dao;

import java.util.List;

import javax.ws.rs.GET;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mzjf.temp.entity.Comment;
import com.mzjf.temp.entity.CommentPraise;

@Mapper
public interface CommentPraiseDao {

    
    @Select("select * from comment where id = #{id}")
    public List<CommentPraise> scan(@Param("id") Long id);

    @Insert("insert into comment(name) values (#{comment.name})")
    public long add(@Param("comment") CommentPraise comment);

    @Update("update comment set status = #{comment.status} where id = #{comment.id} ")
    public void update(@Param("comment") CommentPraise comment);

}
