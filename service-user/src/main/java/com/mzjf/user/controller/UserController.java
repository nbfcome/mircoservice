/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.user.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.common.service.models.UserSpec;
import com.mzjf.user.services.UserSerivce;

@RestController
public class UserController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserEntity get(@PathVariable Long id) {
        return this.userSerivce.getUserById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserSpec post(@RequestBody UserSpec userSpec) {
        this.userSerivce.add(userSpec);
        return userSpec;
    }
}
