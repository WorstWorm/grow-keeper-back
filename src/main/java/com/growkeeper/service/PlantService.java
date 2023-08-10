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

    public Plant getPlant(String plant) {
        return plantRepository.findById(plant).orElseThrow(PlantNotFoundException::new);
    }

    public List<Plant> getPlants() {
        return plantRepository.findAll();
    }

    public void addPlant(Plant plant) {
        if(plantRepository.findById(plant.getPlantScientificName()).isPresent()) {
            plantRepository.deleteById(plant.getPlantScientificName());
        }
        plantRepository.save(plant);
    }

    public void deletePlant(String plantScientificName)  {
        if(plantRepository.findById(plantScientificName).isPresent()) {
            plantRepository.deleteById(plantScientificName);
        } else {
            throw new PlantNotFoundException();
        }
    }
}
