package com.growkeeper.service;

import com.growkeeper.clients.FreePlantClient;
import com.growkeeper.domain.Area;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.observer.AreaObservable;
import com.growkeeper.observer.AreaObserver;
import com.growkeeper.repository.AreaRepository;
import com.growkeeper.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService implements AreaObservable {
    private final AreaRepository areaRepository;
    private final PlantRepository plantRepository;
    private final FreePlantClient freePlantClient;

    private final List<AreaObserver> areaObserverList = new ArrayList<>();

    public Area getArea(Integer areaId) {
        return areaRepository.findById(areaId).orElseThrow(AreaNotFoundException::new);
    }

    public List<Area> getAreas() {
        return areaRepository.findAll();
    }

    private void checkIfPlantExistOrAdd(String plantName) {
        if(!plantName.equals(" ")) {
            if (plantRepository.findById(plantName).isEmpty()) {
                freePlantClient.getPlantInfo(plantName);
            }
        }
    }

    public void createArea() {
        areaRepository.save(new Area());
    }

    public void updateArea(Integer areaId, Area area) {
        checkIfPlantExistOrAdd(area.getAreaScientificName());
        if(areaRepository.findById(areaId).isPresent()) {
            Area areaModified = areaRepository.findById(areaId).get();
            areaModified.setAreaInsolation(area.getAreaInsolation());
            areaModified.setAreaScientificName(area.getAreaScientificName());
            areaModified.setAreaCovered(area.getAreaCovered());
            areaRepository.save(areaModified);
            notifyAreaObservers();
        } else {
            throw new AreaNotFoundException();
        }
    }

    public void deleteArea(Integer areaId)  {
        if(areaRepository.findById(areaId).isPresent()) {
            areaRepository.deleteById(areaId);
            notifyAreaObservers();
        } else {
            throw new AreaNotFoundException();
        }
    }

    @Override
    public void addAreaObserver(AreaObserver observer) {
        areaObserverList.add(observer);
    }

    @Override
    public void notifyAreaObservers() {
        for(AreaObserver areaObserver : areaObserverList) {
            areaObserver.areaChanged();
        }
    }
}
