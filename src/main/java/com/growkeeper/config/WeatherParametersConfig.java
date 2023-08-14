package com.growkeeper.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WeatherParametersConfig {

    @Value("${weather.rain.none}")
    private double rain_none;

    @Value("${weather.wind.strong}")
    private double wind_strong;

    @Value("${weather.wind.verystrong}")
    private double wind_verystrong;

    @Value("${weather.temperature.low}")
    private double temperature_low;

    @Value("${weather.temperature.high}")
    private double temperature_high;

    @Value("${weather.temperature.veryhigh}")
    private double temperature_veryhigh;

    @Value("${weather.clouds.high}")
    private int clouds_high;
}
