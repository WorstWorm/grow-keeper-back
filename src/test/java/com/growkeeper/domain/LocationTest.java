package com.growkeeper.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {

    @Test
    void locationConstructorAndGettersTest() {
        //GIVEN
        String city = "City";
        String state = "State";
        String country = "Country";
        Double latitude = 0.0;
        Double longitude = 50.50;

        //WHEN
        Location location = new Location(city, state, country, latitude, longitude);

        //THEN
        assertEquals(city, location.getLocationCity());
        assertEquals(state, location.getLocationState());
        assertEquals(country, location.getLocationCountry());
        assertEquals(latitude, location.getLocationLatitude());
        assertEquals(longitude, location.getLocationLongitude());
    }

    @Test
    void locationSettersTest() {
        //GIVEN
        Location location = new Location();

        String city = "City";
        String state = "State";
        String country = "Country";
        Double latitude = 0.0;
        Double longitude = 50.50;

        //WHEN
        location.setLocationCity(city);
        location.setLocationState(state);
        location.setLocationCountry(country);
        location.setLocationLatitude(latitude);
        location.setLocationLongitude(longitude);

        //THEN
        assertEquals(city, location.getLocationCity());
        assertEquals(state, location.getLocationState());
        assertEquals(country, location.getLocationCountry());
        assertEquals(latitude, location.getLocationLatitude());
        assertEquals(longitude, location.getLocationLongitude());
    }
}