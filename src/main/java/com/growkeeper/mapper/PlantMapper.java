package com.growkeeper.mapper;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.PlantDto;
import com.growkeeper.dto.api.freePlantDto.FreePlantRootDto;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantMapper {
    public Plant mapToPlant(final PlantDto plantDto) {
        return new Plant(
            plantDto.getPlantScientificName(),
            plantDto.getPlantCommonName(),
            plantDto.getPlantWatering(),
            plantDto.getPlantSunlight()
        );
    }

    public Plant mapToPlant(final FreePlantRootDto freePlantRootDto) {
        return new Plant(
                freePlantRootDto.getData().get(0).getScientific_name().get(0),
                freePlantRootDto.getData().get(0).getCommon_name(),
                WateringOptions.valueOf(freePlantRootDto.getData().get(0).getWatering().toUpperCase()),
                InsolationOptions.valueOf(freePlantRootDto.getData().get(0).getSunlight().get(0).toUpperCase().replace(" ", "_"))
        );
    }

    public PlantDto mapToPlantDto(final Plant plant) {
        return new PlantDto(
                plant.getPlantScientificName(),
                plant.getPlantCommonName(),
                plant.getPlantWatering(),
                plant.getPlantSunlight()
        );
    }

    public List<Plant> mapToPlantList(final List<PlantDto> plantDtoList) {
        return plantDtoList.stream().map(this::mapToPlant).collect(Collectors.toList());
    }

    public List<PlantDto> mapToPlantDtoList(final List<Plant> plantList) {
        return plantList.stream().map(this::mapToPlantDto).collect(Collectors.toList());
    }

}
