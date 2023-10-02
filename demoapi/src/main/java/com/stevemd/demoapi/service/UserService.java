package com.stevemd.demoapi.service;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> users() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        System.out.println("Created a new user: "+user);
        log.info(String.valueOf(HttpStatus.CREATED));
    }
}
