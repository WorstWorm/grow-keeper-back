package com.growkeeper.service;

import com.growkeeper.domain.Weather;
import com.growkeeper.exception.WeatherNotFoundException;
import com.growkeeper.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public Weather getWeather(Integer weatherId) {
        return weatherRepository.findById(weatherId).orElseThrow(WeatherNotFoundException::new);
    }

    public List<Weather> getWeathers() {
        return weatherRepository.findAll();
    }

    public void createWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    public void updateWeather(Integer weatherId, Weather weather)  {
        if(weatherRepository.findById(weatherId).isPresent()) {
            Weather weatherModificated = weatherRepository.findById(weatherId).get();
            weatherModificated.setWeatherId(weather.getWeatherId());
            weatherModificated.setWeatherTemperatureAvrg(weather.getWeatherTemperatureAvrg());
            weatherModificated.setWeatherClouds(weather.getWeatherClouds());
            weatherModificated.setWeatherWind(weather.getWeatherWind());
            weatherModificated.setWeatherType(weather.getWeatherType());
            weatherRepository.save(weatherModificated);
        } else {
            throw new WeatherNotFoundException();
        }
    }

    public void deleteWeather(Integer weatherId)  {
        if(weatherRepository.findById(weatherId).isPresent()) {
            weatherRepository.deleteById(weatherId);
        } else {
            throw new WeatherNotFoundException();
        }
    }
}
