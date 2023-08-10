package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.exception.MultipleLocationsFoundException;
import com.growkeeper.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location getLocation() {
        if(locationRepository.findAll().isEmpty()){
            throw new LocationNotFoundException();
        } else if (locationRepository.findAll().size() > 1) {
            throw new MultipleLocationsFoundException();
        } else {
            return locationRepository.findAll().get(0);
        }
    }

    public void addLocation(Location location) {
        locationRepository.deleteAll();
        locationRepository.save(location);
    }
}
