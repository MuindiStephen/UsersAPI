package com.stevemd.demoapi.config;

import com.stevemd.demoapi.entity.User;
import com.stevemd.demoapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

              userRepository.save(muindi);
              userRepository.save(mirriam);

              System.out.println("Users saved successfully.");
          }catch (Exception e) {

              e.printStackTrace();
              System.err.println("Error while saving users: " + e.getMessage());
          }

        };

    }
}
