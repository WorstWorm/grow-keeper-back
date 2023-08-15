package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.observer.LocationObserver;
import com.growkeeper.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void getLocation_LocationFoundTest() {
        List<Location> locations = new ArrayList<>();
        Location expectedLocation = new Location();
        expectedLocation.setLocationCity("City");
        expectedLocation.setLocationCountry("Country");
        locations.add(expectedLocation);
        when(locationRepository.findAll()).thenReturn(locations);

        Location actualLocation = locationService.getLocation();

        assertEquals(expectedLocation, actualLocation);
    }

    @Test
    public void getLocation_LocationNotFoundTest() {
        when(locationRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(LocationNotFoundException.class, () -> locationService.getLocation());
    }

    @Test
    public void addLocationTest() {
        Location locationToAdd = new Location();
        locationToAdd.setLocationCity("NewCity");
        locationToAdd.setLocationCountry("NewCountry");
        doNothing().when(locationRepository).deleteAll();
        when(locationRepository.save(locationToAdd)).thenReturn(locationToAdd);

        locationService.addLocation(locationToAdd);

        verify(locationRepository).deleteAll();
        verify(locationRepository).save(locationToAdd);
    }

    @Test
    public void addLocationObserverTest() {
        LocationObserver observer = mock(LocationObserver.class);

        locationService.addLocationObserver(observer);
        Location location = new Location();
        location.setLocationCity("City");
        location.setLocationCountry("Country");
        locationService.notifyLocationObservers(location);

        verify(observer).locationChanged(any(Location.class));
    }
}