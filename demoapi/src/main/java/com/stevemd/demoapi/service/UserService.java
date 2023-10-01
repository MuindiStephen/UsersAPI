package com.stevemd.demoapi.service;

import com.stevemd.demoapi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class UserService {

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
