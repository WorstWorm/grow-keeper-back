package com.growkeeper.mapper;

import com.growkeeper.domain.Location;
import com.growkeeper.dto.LocationDto;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherCityRootDto;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherLocalNamesDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationMapperTest {

    @Test
    void mapToLocationFromLocationDtoTest() {
        //GIVEN
        LocationMapper locationMapper = new LocationMapper();

        //WHEN
        LocationDto givenLocationDto = new LocationDto("Example city", "Example state", "Example country", 0.0, 9.9);
        Location receivedLocation = locationMapper.mapToLocation(givenLocationDto);
        Location expectedLocation = new Location("Example city", "Example state", "Example country", 0.0, 9.9);

        //THEN
        assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationFromLocationDtoWithNullTest() {
        //GIVEN
        LocationMapper locationMapper = new LocationMapper();

        //WHEN
        LocationDto givenLocationDto = new LocationDto("Example city", null, "Example country", 0.0, 9.9);
        Location receivedLocation = locationMapper.mapToLocation(givenLocationDto);
        Location expectedLocation = new Location("Example city", null, "Example country", 0.0, 9.9);

        //THEN
        assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationFromOpenWeatherCityDtoTest() {
        //GIVEN
        LocationMapper locationMapper = new LocationMapper();

        //WHEN
        OpenWeatherCityRootDto givenOpenWeatherCityDto = new OpenWeatherCityRootDto();
        OpenWeatherLocalNamesDto openWeatherLocalNamesDto = new OpenWeatherLocalNamesDto();
        openWeatherLocalNamesDto.setEn("Example city");
        givenOpenWeatherCityDto.setLocal_names(openWeatherLocalNamesDto);
        givenOpenWeatherCityDto.setState("Example state");
        givenOpenWeatherCityDto.setCountry("Example country");
        givenOpenWeatherCityDto.setLat(0.0);
        givenOpenWeatherCityDto.setLon(9.9);
        Location receivedLocation = locationMapper.mapToLocation(givenOpenWeatherCityDto);
        Location expectedLocation = new Location("Example city", "Example state", "Example country", 0.0, 9.9);

        //THEN
        assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationDtoFromLocationTest() {
        //GIVEN
        LocationMapper locationMapper = new LocationMapper();

        //WHEN
        Location givenLocation = new Location("Example city", "Example state", "Example country", 0.0, 9.9);
        LocationDto receivedLocationDto = locationMapper.mapToLocationDto(givenLocation);
        LocationDto expectedLocationDto = new LocationDto("Example city", "Example state", "Example country", 0.0, 9.9);

        //THEN
        assertEquals(expectedLocationDto.getLocationCity(), receivedLocationDto.getLocationCity());
        assertEquals(expectedLocationDto.getLocationState(), receivedLocationDto.getLocationState());
        assertEquals(expectedLocationDto.getLocationCountry(), receivedLocationDto.getLocationCountry());
        assertEquals(expectedLocationDto.getLocationLongitude(), receivedLocationDto.getLocationLongitude());
        assertEquals(expectedLocationDto.getLocationLatitude(), receivedLocationDto.getLocationLatitude());
    }
}