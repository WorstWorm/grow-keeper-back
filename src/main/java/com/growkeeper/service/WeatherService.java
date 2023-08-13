package com.growkeeper.service;

import com.growkeeper.domain.Weather;
import com.growkeeper.observer.WeatherObservable;
import com.growkeeper.observer.WeatherObserver;
import com.growkeeper.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService implements WeatherObservable {
    private final WeatherRepository weatherRepository;

    private List<WeatherObserver> weatherObserverList = new ArrayList<>();

    public List<Weather> getWeathers() {
        return weatherRepository.findAll();
    }

    public void addWeatherInBulk(List<Weather> weatherList) {
        weatherRepository.deleteAll();
        weatherRepository.saveAll(weatherList);
        notifyWeatherObservers();
    }

    @Override
    public void addWeatherObserver(WeatherObserver observer) {
        weatherObserverList.add(observer);
    }

    @Override
    public void removeWeatherObserver(WeatherObserver observer) {
        weatherObserverList.remove(observer);
    }

    @Override
    public void notifyWeatherObservers() {
        for(WeatherObserver observer : weatherObserverList) {
            observer.weatherChanged();
        }
    }
}
