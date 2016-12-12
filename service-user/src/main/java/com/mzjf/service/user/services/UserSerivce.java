package com.mzjf.service.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mzjf.service.user.dao.UserDao;
import com.mzjf.service.user.entity.UserEntity;

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

}
