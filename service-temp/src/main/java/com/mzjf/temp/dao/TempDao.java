/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.utils.BatchProvider;

@Mapper
public interface TempDao {

    @Select("select * from user where id = #{id}")
    public List<UserEntity> getUserById(@Param("id") Long id);

    @Insert("insert into user(name) values (#{userEntity.name})")
    public long add(@Param("userEntity") UserEntity userEntity);

    @InsertProvider(type = BatchProvider.class, method = "insertAll")
    public void batchAdd(@Param("list") List<UserEntity> userEntities);

    @Update("update user set name = #{userEntity.name} where id = #{userEntity.id} ")
    public void update(@Param("userEntity") UserEntity userEntity);

}
