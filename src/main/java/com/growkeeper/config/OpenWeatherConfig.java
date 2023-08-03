package com.growkeeper.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class OpenWeatherConfig {

    @Value("${openweather.api.geocoding.endpoint}")
    private String openweatherApiGeocodingEndpoint;

    @Value("${openweather.api.weather.endpoint}")
    private String openweatherApiWeatherEndpoint;

    @Value("${openweather.api.key}")
    private String openweatherApiKey;
}
