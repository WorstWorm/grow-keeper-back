package com.growkeeper.controller;

import com.growkeeper.dto.WeatherDto;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class WeatherControllerTest {
    @Mock
    private WeatherService weatherService;
    @Mock
    private WeatherMapper weatherMapper;
    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getWeathersTest() {
        //GIVEN
        List<WeatherDto> expectedWeatherDtos = new ArrayList<>();
        when(weatherService.getWeathers()).thenReturn(new ArrayList<>());
        when(weatherMapper.mapToWeatherDtoList(new ArrayList<>())).thenReturn(expectedWeatherDtos);

        //WHEN
        ResponseEntity<List<WeatherDto>> response = weatherController.getWeathers();

        //THEN
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedWeatherDtos, response.getBody());
    }
}
