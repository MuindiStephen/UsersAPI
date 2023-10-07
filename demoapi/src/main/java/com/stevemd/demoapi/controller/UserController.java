package com.stevemd.demoapi.controller;


import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping(path = "/api/v1/users/")
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

   @PostMapping(path = "register")
    public void registerNewUser(@RequestBody User user) {
       userService.addNewUser(user);
   }

   @DeleteMapping(path = "{userId}")
    public void deleteUser(
            @PathVariable ("userId") Long userId
   ) {
       userService.deleteUser(userId);
   }

   @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

                userService.updateUser(userId,name,email);
   }

}