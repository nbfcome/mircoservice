/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.service.models.UserSpec;
import com.mzjf.common.service.models.builders.UserSpecBuilder;
import com.mzjf.temp.dao.TempDao;

@Component
public class TempSerivce {
    private static final Logger logger = LoggerFactory.getLogger(TempSerivce.class);

    @Autowired
    private TempDao tempDao;

    public UserSpec getUserById(Long id) {
        List<UserEntity> users = this.tempDao.getUserById(id);
        if (CollectionUtils.isEmpty(users)) {
            return new UserSpec();
        }
        return UserSpecBuilder.toModel(users.get(0));
    }

    public void add(UserSpec userSpec) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSpec.getName());
        this.tempDao.add(userEntity);
        logger.info("increment id {}", userEntity.getId());
    }

    public void batchAdd(List<UserSpec> userSpecs) {
        if (CollectionUtils.isEmpty(userSpecs)) {
            logger.info("userSpecs is empty!");
            return;
        }
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        for (UserSpec userSpec : userSpecs) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userSpec.getName());
            userEntities.add(userEntity);
        }
        this.tempDao.batchAdd(userEntities);
    }

    public void update(Long id, UserSpec userSpec) {
        if (userSpec == null) {
            return;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSpec.getName());
        userEntity.setId(id);
        this.tempDao.update(userEntity);
    }

    protected void setTempDao(TempDao tempDao) {
        this.tempDao = tempDao;
    }

}
