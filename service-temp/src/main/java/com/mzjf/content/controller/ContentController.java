/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.content.controller;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzjf.common.service.models.content.ContentModel;
import com.mzjf.content.service.ContentSerivce;

@RestController
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentSerivce contentSerivce;

    @ApiOperation("Post content")
    @RequestMapping(value = "/contents", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public ContentModel post(@RequestBody @Valid ContentModel contentModel) {
        
        return contentModel;
    }

//    @ApiOperation("get user entity")
//    @RequestMapping(value = "/contents/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
//    @ResponseBody
//    public UserSpec get(@PathVariable Long id) {
//        logger.info("id {}", id);
//        return this.contentSerivce.
//    }
//
//    @ApiOperation("get user entity")
//    @RequestMapping(value = "/users/{userId}/contents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
//    @ResponseBody
//    public List<CommentModel> scan(@PathVariable Long userId) {
//        return this.contentSerivce.getUserById(userId);
//    }

}
