package com.stevemd.demoapi.repository;

import com.stevemd.demoapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


//    public default List<User> users() {
//        return List.of(
//                new User(
//                        1L,
//                        "Md",
//                        "md@gmail.com",
//                        "md1234"
//                )
//        );
//    }


}
