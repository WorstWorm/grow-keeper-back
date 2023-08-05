package com.growkeeper.service.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.growkeeper.clients.OpenWeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenWeatherService {
    private final OpenWeatherClient openWeatherClient;

    public void getWeather(double lat, double lon) throws JsonProcessingException {
        openWeatherClient.getWeather(lat, lon);
    }

    public void getLocation(String city) {
        openWeatherClient.getLocation(city);
    }
}
