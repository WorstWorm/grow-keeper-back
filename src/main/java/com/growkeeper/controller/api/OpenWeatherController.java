package com.growkeeper.controller.api;

import com.growkeeper.service.api.OpenWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/openweather/")
@RequiredArgsConstructor
public class OpenWeatherController {
    private final OpenWeatherService openWeatherService;

    @GetMapping("/{city}")
    public void getLocation(@PathVariable("city") String city) {
        openWeatherService.getLocation(city);
    }

    @GetMapping("/{lat}/{lon}")
    public void getName(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        openWeatherService.getWeather(lat, lon);
    }

}
