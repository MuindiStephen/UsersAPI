package com.stevemd.demoapi.controller;


import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {


   private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
       this.userService = userService;
   }

   @GetMapping
    public List<User> users() {
       return userService.users();
   }
}