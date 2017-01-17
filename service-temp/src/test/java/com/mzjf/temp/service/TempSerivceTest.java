/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.service.models.UserSpec;
import com.mzjf.common.service.models.builders.UserSpecBuilder;
import com.mzjf.temp.dao.TempDao;

/**
 * Tests {@link TempSerivce}.
 */
public class TempSerivceTest {

    private TempSerivce service;
    private TempDao tempDao;

    @Before
    public void setUp() throws Exception {
        this.service = new TempSerivce();
        this.tempDao = mock(TempDao.class);
        this.service.setTempDao(this.tempDao);
    }

    /**
     * Tests {@link TempSerivce#getUserById(Long)}.
     */
    @Test
    public void testGetUserById() {
        UserSpec userSpec = UserSpecBuilder.createTestModel();
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(UserSpecBuilder.fromModel(1L, userSpec));
        Mockito.when(this.tempDao.getUserById(Mockito.any(Long.class))).thenReturn(userEntities);

        UserSpec result = this.service.getUserById(1L);
        Assert.assertThat(userSpec.getName(), Matchers.equalTo(result.getName()));

    }

}
