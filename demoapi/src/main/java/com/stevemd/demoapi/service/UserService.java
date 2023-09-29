package com.stevemd.demoapi.service;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepo userRepo;

    public User createUser(User user) {
        try{

            //String sql = "INSERT INTO users(name,password,username) VALUES(?, ?, ?)";

          //  jdbcTemplate.update(sql, new Object()[user.getName(),get]);
            userRepo.save(user);
            return user;

        }catch (Exception e){
            log.error("An error occurred",e);
            return null;
        }
    }

    public String deleteUser(User user) {
       userRepo.delete(user);
       return "Success";
    }

    public List<User> viewUsers() {
        return userRepo.findAll();
    }
}
