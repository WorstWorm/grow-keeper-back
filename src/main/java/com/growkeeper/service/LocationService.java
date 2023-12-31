package com.growkeeper.service;

import com.growkeeper.domain.Location;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.exception.MultipleLocationsFoundException;
import com.growkeeper.observer.LocationObservable;
import com.growkeeper.observer.LocationObserver;
import com.growkeeper.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService implements LocationObservable {
    private final LocationRepository locationRepository;
    private final List<LocationObserver> observers = new ArrayList<>();

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
        notifyLocationObservers(location);
    }

    @Override
    public void addLocationObserver(LocationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyLocationObservers(Location newLocation) {
        for(LocationObserver observer : observers) {
            observer.locationChanged(newLocation);
        }
    }
}
