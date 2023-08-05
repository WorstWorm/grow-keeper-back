package com.growkeeper.mapper;

import com.growkeeper.domain.Location;
import com.growkeeper.dto.LocationDto;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherCityRootDto;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper {
    public Location mapToLocation(final LocationDto locationDto) {
        return new Location(
                locationDto.getLocationCity(),
                locationDto.getLocationState(),
                locationDto.getLocationCountry(),
                locationDto.getLocationLatitude(),
                locationDto.getLocationLongitude()
        );
    }

    public Location mapToLocation(final OpenWeatherCityRootDto openWeatherCityRootDto) {
        return new Location(
                openWeatherCityRootDto.getLocal_names().getEn(),
                openWeatherCityRootDto.getState(),
                openWeatherCityRootDto.getCountry(),
                openWeatherCityRootDto.getLat(),
                openWeatherCityRootDto.getLon()
        );
    }

    public LocationDto mapToLocationDto(final Location location) {
        return new LocationDto(
                location.getLocationCity(),
                location.getLocationState(),
                location.getLocationCountry(),
                location.getLocationLatitude(),
                location.getLocationLongitude()
        );
    }
}