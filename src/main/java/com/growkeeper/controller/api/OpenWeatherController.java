package com.growkeeper.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.growkeeper.service.api.OpenWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/openweather/")
@RequiredArgsConstructor
public class OpenWeatherController {
    private final OpenWeatherService openWeatherService;

    @GetMapping("/{lat}/{lon}")
    public void getName(@PathVariable("lat") double lat, @PathVariable("lon") double lon) throws JsonProcessingException {
        openWeatherService.getWeather(lat, lon);
    }

    @GetMapping("/{city}")
    public void getLocation(@PathVariable("city") String city) {
        openWeatherService.getLocation(city);
    }
}
