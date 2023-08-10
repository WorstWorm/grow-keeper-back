package com.growkeeper.service;

import com.growkeeper.clients.FreePlantClient;
import com.growkeeper.domain.Area;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.repository.AreaRepository;
import com.growkeeper.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;
    private final PlantRepository plantRepository;
    private final FreePlantClient freePlantClient;

    public Area getArea(Integer areaId) {
        return areaRepository.findById(areaId).orElseThrow(AreaNotFoundException::new);
    }

    public List<Area> getAreas() {
        return areaRepository.findAll();
    }

    private void checkIfPlantExistOrAdd(String plantName) {
        if(!plantName.equals(" ")) {
            if (plantRepository.findById(plantName).isEmpty()) {
                freePlantClient.getPlant(plantName);
            }
        }
    }

    public void createArea(Area area) {
        checkIfPlantExistOrAdd(area.getAreaScientificName());
        areaRepository.save(area);
    }

    public void updateArea(Integer areaId, Area area) {
        checkIfPlantExistOrAdd(area.getAreaScientificName());
        if(areaRepository.findById(areaId).isPresent()) {
            Area areaModified = areaRepository.findById(areaId).get();
            areaModified.setAreaInsolation(area.getAreaInsolation());
            areaModified.setAreaScientificName(area.getAreaScientificName());
            areaRepository.save(areaModified);
        } else {
            throw new AreaNotFoundException();
        }
    }

    public void deleteArea(Integer areaId)  {
        if(areaRepository.findById(areaId).isPresent()) {
            areaRepository.deleteById(areaId);
        } else {
            throw new AreaNotFoundException();
        }
    }
}
