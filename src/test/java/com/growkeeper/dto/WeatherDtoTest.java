package com.growkeeper.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDtoTest {
    @Test
    void weatheConstructorAndGettersTest() {
        //GIVEN
        Double weatherTemperature = 10.0;
        String weatherType = "Rain";
        Integer weatherClouds = 50;
        Double weatherWind = 5.5;
        Double weatherRain = 0.0;
        LocalDateTime weatherTime = LocalDateTime.of(2020,1,1,12,0);

        //WHEN
        WeatherDto weatherDto = new WeatherDto(weatherTemperature, weatherType, weatherClouds, weatherWind, weatherRain, weatherTime);

        //THEN
        assertEquals(weatherTemperature, weatherDto.getWeatherTemperature());
        assertEquals(weatherType, weatherDto.getWeatherType());
        assertEquals(weatherClouds, weatherDto.getWeatherClouds());
        assertEquals(weatherWind, weatherDto.getWeatherWind());
        assertEquals(weatherRain, weatherDto.getWeatherRain());
        assertEquals(weatherTime, weatherDto.getWeatherTime());
    }

    @Test
    void weatherDtoSettersTest() {
        //GIVEN
        WeatherDto weatherDto = new WeatherDto();

        Double weatherTemperature = 10.0;
        String weatherType = "Rain";
        Integer weatherClouds = 50;
        Double weatherWind = 5.5;
        Double weatherRain = 0.0;
        LocalDateTime weatherTime = LocalDateTime.of(2020,1,1,12,0);

        //WHEN
        weatherDto.setWeatherTemperature(weatherTemperature);
        weatherDto.setWeatherType(weatherType);
        weatherDto.setWeatherClouds(weatherClouds);
        weatherDto.setWeatherWind(weatherWind);
        weatherDto.setWeatherRain(weatherRain);
        weatherDto.setWeatherTime(weatherTime);

        //THEN
        assertEquals(weatherTemperature, weatherDto.getWeatherTemperature());
        assertEquals(weatherType, weatherDto.getWeatherType());
        assertEquals(weatherClouds, weatherDto.getWeatherClouds());
        assertEquals(weatherWind, weatherDto.getWeatherWind());
        assertEquals(weatherRain, weatherDto.getWeatherRain());
        assertEquals(weatherTime, weatherDto.getWeatherTime());
    }
}
