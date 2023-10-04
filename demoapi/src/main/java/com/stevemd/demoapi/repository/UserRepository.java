package com.stevemd.demoapi.repository;

import com.stevemd.demoapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long> {
    //@Query("SELECT u FROM User WHERE u.email =?1 ")
    Optional<User> findByEmail(String name);
}



