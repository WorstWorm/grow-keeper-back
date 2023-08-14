package com.growkeeper.mapper;

import com.growkeeper.domain.Location;
import com.growkeeper.dto.LocationDto;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherCityRootDto;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherLocalNamesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationMapperTest {

    @Test
    void mapToLocationFromLocationDto_valid() {
        //Given
        LocationMapper locationMapper = new LocationMapper();

        //When
        LocationDto givenLocationDto = new LocationDto("Example city", "Example state", "Example country", 0.0, 9.9);
        Location receivedLocation = locationMapper.mapToLocation(givenLocationDto);
        Location expectedLocation = new Location("Example city", "Example state", "Example country", 0.0, 9.9);

        //Then
        Assertions.assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        Assertions.assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        Assertions.assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        Assertions.assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        Assertions.assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationFromLocationDtoWithNull_valid() {
        //Given
        LocationMapper locationMapper = new LocationMapper();

        //When
        LocationDto givenLocationDto = new LocationDto("Example city", null, "Example country", 0.0, 9.9);
        Location receivedLocation = locationMapper.mapToLocation(givenLocationDto);
        Location expectedLocation = new Location("Example city", null, "Example country", 0.0, 9.9);

        //Then
        Assertions.assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        Assertions.assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        Assertions.assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        Assertions.assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        Assertions.assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationFromOpenWeatherCityDto_valid() {
        //Given
        LocationMapper locationMapper = new LocationMapper();

        //When
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

        //Then
        Assertions.assertEquals(expectedLocation.getLocationCity(), receivedLocation.getLocationCity());
        Assertions.assertEquals(expectedLocation.getLocationState(), receivedLocation.getLocationState());
        Assertions.assertEquals(expectedLocation.getLocationCountry(), receivedLocation.getLocationCountry());
        Assertions.assertEquals(expectedLocation.getLocationLongitude(), receivedLocation.getLocationLongitude());
        Assertions.assertEquals(expectedLocation.getLocationLatitude(), receivedLocation.getLocationLatitude());
    }

    @Test
    void mapToLocationDtoFromLocation() {
        //Given
        LocationMapper locationMapper = new LocationMapper();

        //When
        Location givenLocation = new Location("Example city", "Example state", "Example country", 0.0, 9.9);
        LocationDto receivedLocationDto = locationMapper.mapToLocationDto(givenLocation);
        LocationDto expectedLocationDto = new LocationDto("Example city", "Example state", "Example country", 0.0, 9.9);

        //Then
        Assertions.assertEquals(expectedLocationDto.getLocationCity(), receivedLocationDto.getLocationCity());
        Assertions.assertEquals(expectedLocationDto.getLocationState(), receivedLocationDto.getLocationState());
        Assertions.assertEquals(expectedLocationDto.getLocationCountry(), receivedLocationDto.getLocationCountry());
        Assertions.assertEquals(expectedLocationDto.getLocationLongitude(), receivedLocationDto.getLocationLongitude());
        Assertions.assertEquals(expectedLocationDto.getLocationLatitude(), receivedLocationDto.getLocationLatitude());
    }
}