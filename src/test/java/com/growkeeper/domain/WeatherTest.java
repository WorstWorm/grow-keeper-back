package com.growkeeper.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {
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
        Weather weather = new Weather(weatherTemperature, weatherType, weatherClouds, weatherWind, weatherRain, weatherTime);

        //THEN
        assertEquals(weatherTemperature, weather.getWeatherTemperature());
        assertEquals(weatherType, weather.getWeatherType());
        assertEquals(weatherClouds, weather.getWeatherClouds());
        assertEquals(weatherWind, weather.getWeatherWind());
        assertEquals(weatherRain, weather.getWeatherRain());
        assertEquals(weatherTime, weather.getWeatherTime());
    }

    @Test
    void weatherSettersTest() {
        //GIVEN
        Weather weather = new Weather();

        Double weatherTemperature = 10.0;
        String weatherType = "Rain";
        Integer weatherClouds = 50;
        Double weatherWind = 5.5;
        Double weatherRain = 0.0;
        LocalDateTime weatherTime = LocalDateTime.of(2020,1,1,12,0);

        //WHEN
        weather.setWeatherTemperature(weatherTemperature);
        weather.setWeatherType(weatherType);
        weather.setWeatherClouds(weatherClouds);
        weather.setWeatherWind(weatherWind);
        weather.setWeatherRain(weatherRain);
        weather.setWeatherTime(weatherTime);

        //THEN
        assertEquals(weatherTemperature, weather.getWeatherTemperature());
        assertEquals(weatherType, weather.getWeatherType());
        assertEquals(weatherClouds, weather.getWeatherClouds());
        assertEquals(weatherWind, weather.getWeatherWind());
        assertEquals(weatherRain, weather.getWeatherRain());
        assertEquals(weatherTime, weather.getWeatherTime());
    }

    @Test
    void compareTest() {
        //GIVEN
        Weather weather1 = new Weather();
        weather1.setWeatherTime(LocalDateTime.of(2020, 1, 1, 12, 0));

        Weather weather2 = new Weather();
        weather2.setWeatherTime(LocalDateTime.of(2020, 1, 1, 12, 0));

        //WHEN
        int received = weather1.compareTo(weather2);
        int expected = 0;

        //THEN
        assertEquals(expected, received);
    }
}
