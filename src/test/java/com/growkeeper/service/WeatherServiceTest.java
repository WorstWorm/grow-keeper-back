package com.growkeeper.service;

import com.growkeeper.domain.Weather;
import com.growkeeper.repository.WeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherService = new WeatherService(weatherRepository);
    }

    @Test
    public void getWeathersTest() {
        List<Weather> expectedWeathers = new ArrayList<>();
        when(weatherRepository.findAll()).thenReturn(expectedWeathers);

        List<Weather> actualWeathers = weatherService.getWeathers();

        assertEquals(expectedWeathers, actualWeathers);
    }

    @Test
    public void addWeatherInBulkTest() {
        List<Weather> weatherList = new ArrayList<>();
        doNothing().when(weatherRepository).deleteAll();
        when(weatherRepository.saveAll(weatherList)).thenReturn(weatherList);

        weatherService.addWeatherInBulk(weatherList);

        verify(weatherRepository).deleteAll();
        verify(weatherRepository).saveAll(weatherList);
    }

}
