package com.growkeeper.service;

import com.growkeeper.clients.FreePlantClient;
import com.growkeeper.dto.FreePlantDetailedPlantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreePlantService {
    private final FreePlantClient freePlantClient;

    public FreePlantDetailedPlantDto getDetailsOfPlant(String plantScientificName) {
        return freePlantClient.getPlantDetailsFromFreeplant(plantScientificName);
    }
}
