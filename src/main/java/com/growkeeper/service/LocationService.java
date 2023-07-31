package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location getLocation(String locationCity) {
        return locationRepository.findById(locationCity).orElseThrow(LocationNotFoundException::new);
    }

    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(String locationCity, Location location) {
        if (locationRepository.findById(locationCity).isPresent()) {
            Location locationModificated = locationRepository.findById(locationCity).get();
            locationModificated.setLocationCity(location.getLocationCity());
            locationModificated.setLocationCountry(location.getLocationCountry());
            locationModificated.setLocationLatitude(location.getLocationLatitude());
            locationModificated.setLocationLongitude(location.getLocationLongitude());
            locationRepository.save(locationModificated);
        } else {
            throw new LocationNotFoundException();
        }
    }
}
