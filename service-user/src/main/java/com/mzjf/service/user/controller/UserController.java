package com.mzjf.service.user.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzjf.service.user.entity.UserEntity;
import com.mzjf.service.user.services.UserSerivce;

@RestController
public class UserController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public UserEntity get(@PathVariable Long id) {
        return this.userSerivce.getUserById(id);
    }
}
