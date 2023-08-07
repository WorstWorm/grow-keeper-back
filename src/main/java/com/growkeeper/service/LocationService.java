package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.exception.MultipleLocationsFoundException;
import com.growkeeper.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location getLocation() {
        if(locationRepository.findAll().size() == 0){
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
