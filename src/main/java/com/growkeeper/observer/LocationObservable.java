package com.growkeeper.observer;

import com.growkeeper.domain.Location;

public interface LocationObservable {
    void addObserver(LocationObserver observer);
    void removeObserver(LocationObserver observer);
    void notifyObservers(Location newLocation);
}
