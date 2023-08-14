package com.growkeeper.observer;

public interface WeatherObservable {
    void addWeatherObserver(WeatherObserver observer);
    void notifyWeatherObservers();
}
