/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.service.models.UserSpec;
import com.mzjf.user.dao.UserDao;

@Component
public class UserSerivce {

    @Autowired
    private UserDao userDao;

    public UserEntity getUserById(Long id) {
        List<UserEntity> users = this.userDao.getUserById(id);
        if (CollectionUtils.isEmpty(users)) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(0L);
            userEntity.setName("nbf");
            return userEntity;
        }
        return users.get(0);
    }

    public void add(UserSpec userSpec) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSpec.getName());
        this.userDao.add(userEntity);
    }

}
