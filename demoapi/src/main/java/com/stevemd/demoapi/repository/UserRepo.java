package com.stevemd.demoapi.repository;

import com.stevemd.demoapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();
}
