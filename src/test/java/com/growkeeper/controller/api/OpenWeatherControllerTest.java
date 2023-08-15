package com.growkeeper.controller.api;

import com.growkeeper.service.api.OpenWeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OpenWeatherControllerTest {

    @Mock
    private OpenWeatherService openWeatherService;

    @InjectMocks
    private OpenWeatherController openWeatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getLocationTest() {
        // GIVEN
        String city = "SampleCity";
        doNothing().when(openWeatherService).getLocation(city);

        // WHEN
        openWeatherController.getLocation(city);

        // THEN
        verify(openWeatherService, times(1)).getLocation(city);
    }

    @Test
    void getNameTest() {
        // GIVEN
        double lat = 40.7128;
        double lon = -74.0060;
        doNothing().when(openWeatherService).getWeather(lat, lon);

        // WHEN
        openWeatherController.getName(lat, lon);

        // THEN
        verify(openWeatherService, times(1)).getWeather(lat, lon);
    }
}