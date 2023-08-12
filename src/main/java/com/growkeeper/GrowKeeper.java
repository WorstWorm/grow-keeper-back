package com.growkeeper;

import com.growkeeper.clients.OpenWeatherClient;
import com.growkeeper.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
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
