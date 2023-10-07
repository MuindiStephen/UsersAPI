package com.stevemd.demoapi.service;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateUser(Long userId,String name,String email) {

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException(
                        "User with id: "+userId+" does not exist."
                ));

        if (name!=null && !name.isEmpty() && !Objects.equals(user.getName(),name)){
            user.setName(name);

        }
        if (email!=null && !email.isEmpty() && !Objects.equals(user.getEmail(),email)){

            Optional <User> userUpdate = userRepository.findByEmail(email);

            if (userUpdate.isPresent()) {
                throw new IllegalStateException("Email is already in use by another account.");
            }
            user.setEmail(email);
        }
    }
}
