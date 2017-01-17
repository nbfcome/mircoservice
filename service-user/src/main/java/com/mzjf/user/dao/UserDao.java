/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mzjf.common.service.entity.UserEntity;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public List<UserEntity> getUserById(@Param("id") Long id);

    @Insert("insert into user(name) values (#{userEntity.name})")
    public long add(@Param("userEntity") UserEntity userEntity);

}
