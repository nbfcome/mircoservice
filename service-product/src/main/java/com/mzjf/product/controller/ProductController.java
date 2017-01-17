/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.product.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzjf.common.service.entity.UserEntity;
import com.mzjf.product.service.RibbonService;

@RestController
public class ProductController {
    @Autowired
    private RibbonService ribbonService;

    @RequestMapping(value = "/users/{userId}/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserEntity get(@PathVariable Long userId) {
        return this.ribbonService.getEntity(userId);
    }

}
