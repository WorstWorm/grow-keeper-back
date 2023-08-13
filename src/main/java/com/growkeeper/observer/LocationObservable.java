package com.growkeeper.observer;

import com.growkeeper.domain.Location;

public interface LocationObservable {
    void addLocationObserver(LocationObserver observer);
    void removeLocationObserver(LocationObserver observer);
    void notifyLocationObservers(Location newLocation);
}
