package com.coforge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.coforge")
public class SpringbootjpaLombokApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjpaLombokApplication.class, args);
    }
}