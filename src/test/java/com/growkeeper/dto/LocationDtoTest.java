package com.growkeeper.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationDtoTest {

    @Test
    void locationDtoConstructorAndGettersTest() {
        //GIVEN
        String city = "City";
        String state = "State";
        String country = "Country";
        Double latitude = 0.0;
        Double longitude = 50.50;

        //WHEN
        LocationDto locationDto = new LocationDto(city, state, country, latitude, longitude);

        //THEN
        assertEquals(city, locationDto.getLocationCity());
        assertEquals(state, locationDto.getLocationState());
        assertEquals(country, locationDto.getLocationCountry());
        assertEquals(latitude, locationDto.getLocationLatitude());
        assertEquals(longitude, locationDto.getLocationLongitude());
    }

    @Test
    void locationDtoSettersTest() {
        //GIVEN
        LocationDto locationDto = new LocationDto();

        String city = "City";
        String state = "State";
        String country = "Country";
        Double latitude = 0.0;
        Double longitude = 50.50;

        //WHEN
        locationDto.setLocationCity(city);
        locationDto.setLocationState(state);
        locationDto.setLocationCountry(country);
        locationDto.setLocationLatitude(latitude);
        locationDto.setLocationLongitude(longitude);

        //THEN
        assertEquals(city, locationDto.getLocationCity());
        assertEquals(state, locationDto.getLocationState());
        assertEquals(country, locationDto.getLocationCountry());
        assertEquals(latitude, locationDto.getLocationLatitude());
        assertEquals(longitude, locationDto.getLocationLongitude());
    }
}