package com.growkeeper.observer;

import com.growkeeper.domain.Location;

public interface LocationObserver {

    void locationChanged(Location newLocation);
}
