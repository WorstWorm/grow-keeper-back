package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(String locationCity) {
        return locationRepository.findById(locationCity).orElseThrow(LocationNotFoundException::new);
    }

    public void addLocation(Location location) {
        locationRepository.deleteAll();
        locationRepository.save(location);
    }
}
