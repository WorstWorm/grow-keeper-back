package com.growkeeper.observer;

public interface AreaObservable {
    void addAreaObserver(AreaObserver observer);
    void removeAreaObserver(AreaObserver observer);
    void notifyAreaObservers();
}
