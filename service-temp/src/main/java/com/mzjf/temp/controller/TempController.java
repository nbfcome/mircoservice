/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.temp.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

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

import com.mzjf.common.service.models.UserSpec;
import com.mzjf.temp.service.TempSerivce;

@RestController
public class TempController {
    private static final Logger logger = LoggerFactory.getLogger(TempController.class);
    @Autowired
    private TempSerivce tempSerivce;

    @ApiOperation("get user entity")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserSpec get(@PathVariable Long id) {
        logger.info("id {}", id);
        return this.tempSerivce.getUserById(id);
    }

    @ApiOperation("post user List")
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<UserSpec> post(@RequestBody List<UserSpec> userSpecs) {
        if (userSpecs.isEmpty()) {
            return userSpecs;
        }
        if (userSpecs.size() == 1) {
            this.tempSerivce.add(userSpecs.get(0));
        } else {
            this.tempSerivce.batchAdd(userSpecs);
        }
        //        List<UserSpec> userSpecs = new ArrayList<UserSpec>();
        //        userSpecs.add(userSpec);
        //        userSpecs.add(userSpec);
        //        this.tempSerivce.batchAdd(userSpecs);
        return userSpecs;
    }

    @ApiOperation("get ")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserSpec put(@PathVariable Long id, @RequestBody UserSpec userSpec) {
        this.tempSerivce.update(id, userSpec);
        return userSpec;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public String batchPost() {
        return "Hello World";
    }

    protected void setTempSerivce(TempSerivce tempSerivce) {
        this.tempSerivce = tempSerivce;
    }

}
