/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mzjf.common.service.models.UserSpec;
import com.mzjf.common.service.models.builders.UserSpecBuilder;
import com.mzjf.temp.service.TempSerivce;

/**
 * Tests {@link TempController}}
 *
 */
public class TempControllerTest {

    private TempController controller;
    private TempSerivce tempSerivce;

    @Before
    public void setUp() {
        this.controller = new TempController();
        this.tempSerivce = Mockito.mock(TempSerivce.class);
        this.controller.setTempSerivce(this.tempSerivce);
    }

    /**
     * Tests{@link TempController#get(Long)}
     *
     */
    @Test
    public void testGet() {
        UserSpec userSpec = UserSpecBuilder.createTestModel();
        Mockito.when(this.tempSerivce.getUserById(Mockito.anyLong())).thenReturn(userSpec);
        UserSpec result = this.controller.get(1L);
        Assert.assertThat(userSpec.getName(), org.hamcrest.Matchers.equalTo(result.getName()));
    }

}
