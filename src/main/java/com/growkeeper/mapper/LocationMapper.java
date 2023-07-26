package com.growkeeper.mapper;

import com.growkeeper.domain.Location;
import com.growkeeper.dto.LocationDto;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper {
    public Location mapToLocation(final LocationDto locationDto) {
        return new Location(
                locationDto.getLocationCity(),
                locationDto.getLocationCountry(),
                locationDto.getLocationLatitude(),
                locationDto.getLocationLongitude()
        );
    }

    public LocationDto mapToLocationDto(final Location location) {
        return new LocationDto(
                location.getLocationCity(),
                location.getLocationCountry(),
                location.getLocationLatitude(),
                location.getLocationLongitude()
        );
    }
}