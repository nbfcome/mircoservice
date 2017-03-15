/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzjf.common.service.models.UserModel;
import com.mzjf.common.service.models.UserSpec;
import com.mzjf.temp.service.TempSerivce;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired

    @ApiOperation("get user entity")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserSpec get(@PathVariable Long userId) {
        logger.info("userId {}", userId);
        return this.tempSerivce.getUserById(userId);
    }

    @ApiOperation("user register")
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserModel post(@Valid @RequestBody UserModel userModel) {
        
    }

    @ApiOperation("get ")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserSpec put(@PathVariable Long id, @RequestBody UserSpec userSpec) {
        this.tempSerivce.update(id, userSpec);
        return userSpec;
    }

}
