package com.growkeeper.service;

import com.growkeeper.domain.Plant;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;

    public Plant getPlant(String plantCity) {
        return plantRepository.findById(plantCity).orElseThrow(PlantNotFoundException::new);
    }

    public List<Plant> getPlants() {
        return plantRepository.findAll();
    }

    public void createPlant(Plant plant) {
        plantRepository.save(plant);
    }

    public void updatePlant(String plantCity, Plant plant) {
        if (plantRepository.findById(plantCity).isPresent()) {
            Plant plantModificated = plantRepository.findById(plantCity).get();
            plantModificated.setPlantScientificName(plant.getPlantScientificName());
            plantModificated.setPlantCommonName(plant.getPlantCommonName());
//            plantModificated.setPlantEdible(plant.getPlantEdible());
            plantModificated.setPlantWatering(plant.getPlantWatering());
            plantModificated.setPlantSunlight(plant.getPlantSunlight());
//            plantModificated.setPlantCycle(plant.getPlantCycle());
            plantModificated.setPlantPoisonous(plant.getPlantPoisonous());
//            plantModificated.setPlantDepth(plant.getPlantDepth());
//            plantModificated.setPlantDiameter(plant.getPlantDiameter());
            plantRepository.save(plantModificated);
        } else {
            throw new PlantNotFoundException();
        }
    }

    public void deletePlant(String plantScientificName)  {
        if(plantRepository.findById(plantScientificName).isPresent()) {
            plantRepository.deleteById(plantScientificName);
        } else {
            throw new PlantNotFoundException();
        }
    }
}
