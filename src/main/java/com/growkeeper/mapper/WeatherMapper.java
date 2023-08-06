package com.growkeeper.mapper;

import com.growkeeper.domain.Weather;
import com.growkeeper.dto.WeatherDto;
import com.growkeeper.dto.api.openWeatherDto.weather.OpenWeatherListDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherMapper {
    public Weather mapToWeather(final WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getWeatherTemperature(),
                weatherDto.getWeatherType(),
                weatherDto.getWeatherClouds(),
                weatherDto.getWeatherWind(),
                weatherDto.getWeatherRain(),
                weatherDto.getWeatherTime()
        );
    }

    public Weather mapToWeather(final OpenWeatherListDto openWeatherListDto) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        double rain = 0.0;
        if(openWeatherListDto.getOpenWeatherRainDto() != null) {
            rain = openWeatherListDto.getOpenWeatherRainDto().get_3h();
        }
        return new Weather(
                openWeatherListDto.getOpenWeatherMainDto().getTemp(),
                openWeatherListDto.getOpenWeatherWeatherDto().get(0).getMain(),
                openWeatherListDto.getOpenWeatherCloudsDto().getAll(),
                openWeatherListDto.getOpenWeatherWindDto().getSpeed(),
                rain,
                LocalDateTime.parse(openWeatherListDto.getDt_txt(), dateTimeFormatter)
        );
    }

    public WeatherDto mapToWeatherDto(final Weather weather) {
        return new WeatherDto(
                weather.getWeatherTemperature(),
                weather.getWeatherType(),
                weather.getWeatherClouds(),
                weather.getWeatherWind(),
                weather.getWeatherRain(),
                weather.getWeatherTime()
        );
    }

    public List<Weather> mapToWeatherList(final List<OpenWeatherListDto> openWeatherListDtoList) {
        return openWeatherListDtoList.stream().map(this::mapToWeather).collect(Collectors.toList());
    }

    public List<WeatherDto> mapToWeatherDtoList(final List<Weather> weatherList) {
        return weatherList.stream().map(this::mapToWeatherDto).collect(Collectors.toList());
    }
}
