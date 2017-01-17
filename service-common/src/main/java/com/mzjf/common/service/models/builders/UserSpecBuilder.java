/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.service.models.builders;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.service.models.UserSpec;

public class UserSpecBuilder {

    private String name;

    public UserSpecBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserSpec build() {
        UserSpec result = new UserSpec();
        result.setName(this.name);
        return result;
    }

    public static UserSpec createTestModel() {
        return new UserSpecBuilder()
                .name("nbf")
                .build();
    }

    public static UserEntity fromModel(Long id, UserSpec userSpec) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(userSpec.getName());
        return userEntity;
    }

    public static UserSpec toModel(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserSpec userSpec = new UserSpec();
        userSpec.setName(userEntity.getName());
        return userSpec;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
