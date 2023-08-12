package com.growkeeper.config;

import com.growkeeper.clients.OpenWeatherClient;
import com.growkeeper.observer.LocationObservable;
import com.growkeeper.observer.LocationObserver;
import com.growkeeper.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public LocationObserver openWeatherObserver(LocationObservable locationObservable, OpenWeatherClient openWeatherClient) {
        LocationObserver observer = openWeatherClient;
        locationObservable.addObserver(observer);
        return observer;
    }

//    @Autowired
//    public void setupObservers(LocationService locationService, LocationObserver locationObserver) {
//        locationService.addObserver(locationObserver);
//    }
}
