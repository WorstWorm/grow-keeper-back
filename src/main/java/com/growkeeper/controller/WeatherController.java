package com.growkeeper.controller;

import com.growkeeper.dto.WeatherDto;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    @GetMapping()
    public ResponseEntity<List<WeatherDto>> getWeathers() {
        return ResponseEntity.ok(weatherMapper.mapToWeatherDtoList(weatherService.getWeathers()));
    }

}
