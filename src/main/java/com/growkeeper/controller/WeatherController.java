package com.growkeeper.controller;

import com.growkeeper.dto.WeatherDto;
import com.growkeeper.exception.WeatherNotFoundException;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

//    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> addWeather(@RequestBody WeatherDto weatherDto) {
//        weatherService.addWeather(weatherMapper.mapToWeather(weatherDto));
//        return ResponseEntity.ok().build();
//    }

//    @DeleteMapping("/{time}")
//    public ResponseEntity<Void> deleteWeather(@PathVariable("time") LocalDateTime time) throws WeatherNotFoundException {
//        weatherService.deleteWeather(time);
//        return ResponseEntity.ok().build();
//    }
}
