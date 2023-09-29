package com.stevemd.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@SpringBootApplication
@RestController
public class DemoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring boot and status is "+HttpURLConnection.HTTP_OK;
	}

}
