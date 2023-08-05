package com.growkeeper.service;

import com.growkeeper.domain.Weather;
import com.growkeeper.exception.WeatherNotFoundException;
import com.growkeeper.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public Weather getWeather(LocalDateTime time) {
        return weatherRepository.findByWeatherTime(time).orElseThrow(WeatherNotFoundException::new);
    }

    public List<Weather> getWeathers() {
        return weatherRepository.findAll();
    }

    public void addWeather(Weather weather) {
        weatherRepository.save(weather);
        List<Weather> weatherList = weatherRepository.findAll();
        if(weatherList.size()>1) {
            Collections.sort(weatherList);
            weatherRepository.delete(weatherList.get(0));
        }
    }

    public void addWeatherInBulk(List<Weather> weatherList) {
        weatherRepository.deleteAll();
        for(Weather w : weatherList) {
            weatherRepository.save(w);
        }
    }

    public void deleteWeather(LocalDateTime time)  {
        if(weatherRepository.findByWeatherTime(time).isPresent()) {
            weatherRepository.deleteByWeatherTime(time);
        } else {
            throw new WeatherNotFoundException();
        }
    }
}
