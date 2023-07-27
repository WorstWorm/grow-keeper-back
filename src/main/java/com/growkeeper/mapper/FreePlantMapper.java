package com.growkeeper.mapper;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.FreePlantDetailedPlantDto;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import org.springframework.stereotype.Service;

@Service
public class FreePlantMapper {
    public Plant mapToPlant(final FreePlantDetailedPlantDto freePlantDetailedPlantDto) {
        boolean poisonous;
        if(freePlantDetailedPlantDto.getPlantPoisonous()==0){
            poisonous = false;
        } else {
            poisonous = true;
        }
            return new Plant(
                freePlantDetailedPlantDto.getPlantScientificName(),
                freePlantDetailedPlantDto.getPlantCommonName(),
                WateringOptions.valueOf(freePlantDetailedPlantDto.getPlantWatering()),
                InsolationOptions.valueOf(freePlantDetailedPlantDto.getPlantSunlight()),
                poisonous
        );
    }
}
