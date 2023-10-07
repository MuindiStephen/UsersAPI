package com.stevemd.demoapi.service;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


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

        Optional<User> userByEmail =
                userRepository.findByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            throw new IllegalStateException("Email is already in use by another account");

        }

        userRepository.save(user);

        System.out.println("Created a new user: "+user);

        log.info(String.valueOf(HttpStatus.CREATED));
    }

    public void deleteUser(Long userId) {
       boolean exists = userRepository.existsById(userId);
       if (!exists) {
           throw new IllegalStateException("User with id:"+userId+" does not exist.");
       }
       userRepository.deleteById(userId);
    }
}
