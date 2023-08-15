package com.growkeeper.controller;

import com.growkeeper.domain.Location;
import com.growkeeper.dto.LocationDto;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.mapper.LocationMapper;
import com.growkeeper.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LocationControllerTest {

    @Mock
    private LocationService locationService;

    @Mock
    private LocationMapper locationMapper;

    @InjectMocks
    private LocationController locationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCurrentLocationTest() throws LocationNotFoundException {
        //GIVEN
        LocationDto expectedLocationDto = new LocationDto();
        when(locationService.getLocation()).thenReturn(new Location());
        when(locationMapper.mapToLocationDto(any())).thenReturn(expectedLocationDto);

        //WHEN
        ResponseEntity<LocationDto> response = locationController.getCurrentLocation();

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedLocationDto, response.getBody());
    }

    @Test
    void addNewLocationTest() {
        //GIVEN
        LocationDto locationDto = new LocationDto();
        Location originalLocation = locationService.getLocation();

        //WHEN
        ResponseEntity<Void> response = locationController.addNewLocation(locationDto);

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(locationService, times(1)).addLocation(any());

        //CLEANUP
        locationService.addLocation(originalLocation);
    }
}
