package com.backend.demo.controller;

import com.backend.demo.model.UserDetail;
import com.backend.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="users/signup", method= RequestMethod.POST)
    public String registerUser(UserDetail user) {
        userService.registerUser(user);
        return "details";
    }
}
