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

import com.mzjf.common.service.entity.User;

/**
 * @author niebiaofei
 *
 */
@Mapper
public interface UserDao {

    @Select("select userId, babyName, birthDay, city, createTime, icon, loginType, mobile, nickName"
            + ", province, status, updateTime from user where id = #{id}")
    public List<User> scan(@Param("id") Long id);

    @Insert("insert into user(userId, babyName, birthDay, city, createTime, icon, loginType"
            + ", mobile, nickName, province, status, updateTime) "
            + "values (#{user.userId},#{user.babyName},#{user.birthDay},#{user.city},#{user.createTime}"
            + ",#{user.icon},#{user.loginType},#{user.mobile},#{user.nickName},#{user.province}"
            + ",#{user.status},#{user.updateTime},)")
    public long add(@Param("user") User user);

    @Update("update user set status = #{user.status} where id = #{user.id} ")
    public void update(@Param("user") User user);
}
