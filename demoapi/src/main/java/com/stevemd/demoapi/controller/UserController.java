package com.stevemd.demoapi.controller;


import com.stevemd.demoapi.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @GetMapping
    public List<User> users() {
        return List.of(
                new User(
                        1L,
                        "Steve,",
                        "stephenmuindi@gmail.com",
                        "1234"
                )
        );
    }
}