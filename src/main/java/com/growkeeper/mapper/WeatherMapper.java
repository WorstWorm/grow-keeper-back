package com.growkeeper.mapper;

import com.growkeeper.domain.Weather;
import com.growkeeper.dto.WeatherDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherMapper {
    public Weather mapToWeather(final WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getWeatherId(),
                weatherDto.getWeatherTemperatureAvrg(),
                weatherDto.getWeatherClouds(),
                weatherDto.getWeatherWind(),
                weatherDto.getWeatherType()
        );
    }

    public WeatherDto mapToWeatherDto(final Weather weather) {
        return new WeatherDto(
                weather.getWeatherId(),
                weather.getWeatherTemperatureAvrg(),
                weather.getWeatherClouds(),
                weather.getWeatherWind(),
                weather.getWeatherType()
        );
    }

    public List<Weather> mapToWeatherList(final List<WeatherDto> weatherDtoList) {
        return weatherDtoList.stream().map(this::mapToWeather).collect(Collectors.toList());
    }

    public List<WeatherDto> mapToWeatherDtoList(final List<Weather> weatherList) {
        return weatherList.stream().map(this::mapToWeatherDto).collect(Collectors.toList());
    }
}
