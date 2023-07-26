package com.growkeeper.controller;

import com.growkeeper.dto.WeatherDto;
import com.growkeeper.exception.WeatherNotFoundException;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    @GetMapping("/{id}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable("id") int id) throws WeatherNotFoundException {
        return ResponseEntity.ok(weatherMapper.mapToWeatherDto(weatherService.getWeather(id)));
    }

    @GetMapping()
    public ResponseEntity<List<WeatherDto>> getWeathers() {
        return ResponseEntity.ok(weatherMapper.mapToWeatherDtoList(weatherService.getWeathers()));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createWeather(@RequestBody WeatherDto weatherDto) {
        weatherService.createWeather(weatherMapper.mapToWeather(weatherDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherDto> updateWeather(@PathVariable("id") int id, @RequestBody WeatherDto weatherDto) {
        weatherService.updateWeather(id, weatherMapper.mapToWeather(weatherDto));
        return ResponseEntity.ok(weatherMapper.mapToWeatherDto(weatherService.getWeather(weatherDto.getWeatherId())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable("id") int id) throws WeatherNotFoundException {
        weatherService.deleteWeather(id);
        return ResponseEntity.ok().build();
    }
}
