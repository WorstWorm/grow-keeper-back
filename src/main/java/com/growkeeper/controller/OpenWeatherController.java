package com.growkeeper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.growkeeper.service.OpenWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/openweather/")
@RequiredArgsConstructor
public class OpenWeatherController {
    private final OpenWeatherService openWeatherService;

    @GetMapping("/{lat}/{lon}")
    public void getName(@PathVariable("lat") String lat, @PathVariable("lon") String lon) throws JsonProcessingException {
        openWeatherService.getWeather(lat, lon);
    }

    @GetMapping("/{city}")
    public void getLocation(@PathVariable("city") String city) {
        openWeatherService.getLocation(city);
    }
}
