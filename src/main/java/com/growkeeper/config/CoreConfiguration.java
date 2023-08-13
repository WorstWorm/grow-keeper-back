package com.growkeeper.config;

import com.growkeeper.clients.OpenWeatherClient;
import com.growkeeper.observer.*;
import com.growkeeper.service.ActionService;
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
    public LocationObserver locationObserver(LocationObservable locationObservable, OpenWeatherClient openWeatherClient) {
        locationObservable.addLocationObserver(openWeatherClient);
        return openWeatherClient;
    }

    @Bean
    WeatherObserver weatherObserver(WeatherObservable weatherObservable, ActionService actionService) {
        weatherObservable.addWeatherObserver(actionService);
        return actionService;
    }

    @Bean
    AreaObserver areaObserver(AreaObservable areaObservable, ActionService actionService) {
        areaObservable.addAreaObserver(actionService);
        return actionService;
    }
}
