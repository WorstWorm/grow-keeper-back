package com.growkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GrowKeeper {
    public static void main(String[] args) {
            SpringApplication.run(GrowKeeper.class, args);
    }
}
