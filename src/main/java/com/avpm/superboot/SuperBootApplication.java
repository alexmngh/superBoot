package com.avpm.superboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class SuperBootApplication {


    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(SuperBootApplication.class, args);
    }

}
