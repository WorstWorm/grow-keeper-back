package com.growkeeper.mapper;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.PlantDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantMapper {
    public Plant mapToPlant(final PlantDto plantDto) {
        return new Plant(
            plantDto.getPlantScientificName(),
            plantDto.getPlantCommonName(),
            //plantDto.getPlantEdible(),
            plantDto.getPlantWatering(),
            plantDto.getPlantSunlight(),
            //plantDto.getPlantCycle(),
            plantDto.getPlantPoisonous()
            //plantDto.getPlantDepth(),
            //plantDto.getPlantDiameter()
        );
    }

    public PlantDto mapToPlantDto(final Plant plant) {
        return new PlantDto(
                plant.getPlantScientificName(),
                plant.getPlantCommonName(),
                //plant.getPlantEdible(),
                plant.getPlantWatering(),
                plant.getPlantSunlight(),
                //plant.getPlantCycle(),
                plant.getPlantPoisonous()
                //plant.getPlantDepth(),
                //plant.getPlantDiameter()
        );
    }

    public List<Plant> mapToPlantList(final List<PlantDto> plantDtoList) {
        return plantDtoList.stream().map(this::mapToPlant).collect(Collectors.toList());
    }

    public List<PlantDto> mapToPlantDtoList(final List<Plant> plantList) {
        return plantList.stream().map(this::mapToPlantDto).collect(Collectors.toList());
    }

}
