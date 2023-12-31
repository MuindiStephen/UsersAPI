package com.stevemd.demoapi.config;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository
    ) {
        return args -> {
          try {

              User muindi = new User(
                      1L,
                      "md",
                      "md@gmail.com",
                      "1234"
              );

              User mirriam = new User(
                      2L,
                      "mirriam",
                      "mirriam@gmail.com",
                      "5678"
              );

              User alex = new User(
                      3L,
                      "alex",
                      "alex@gmail.com",
                      "5678"
              );

              User john = new User(
                      4L,
                      "john",
                      "john@gmail.com",
                      "5678"
              );


              userRepository.saveAll(
                      List.of(muindi,mirriam,alex,john)
              );

              log.info("\n-----Success:------- ");
              System.out.println("Users saved successfully");

          }catch (Exception e) {
              System.err.println("Error while saving users: " + e.getMessage());
              log.error("An error occurred",e);
          }
        };
    }
}
