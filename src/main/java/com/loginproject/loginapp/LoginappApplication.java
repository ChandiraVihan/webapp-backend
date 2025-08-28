package com.loginproject.loginapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.loginproject.loginapp") // Explicitly scan for entities
public class LoginappApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginappApplication.class, args);
    }
}
