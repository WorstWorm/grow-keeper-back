package com.growkeeper.mapper;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.PlantDto;
import com.growkeeper.dto.api.freePlantDto.FreePlantDatumDto;
import com.growkeeper.dto.api.freePlantDto.FreePlantRootDto;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlantMapperTest {

    @Test
    void mapToPlantTest() {
        //GIVEN
        PlantMapper plantMapper = new PlantMapper();

        //WHEN
        ArrayList<FreePlantDatumDto> datumList = new ArrayList<>();
        FreePlantDatumDto freePlantDatumDto = new FreePlantDatumDto();
        freePlantDatumDto.setId(1);
        freePlantDatumDto.setCommon_name("Plant common name");
        ArrayList<String> scientificNames = new ArrayList<>();
        scientificNames.add("Plant scientific name");
        freePlantDatumDto.setScientific_name(scientificNames);
        freePlantDatumDto.setWatering("Frequent");
        ArrayList<String> sunlight = new ArrayList<>();
        sunlight.add("full sun");
        freePlantDatumDto.setSunlight(sunlight);
        datumList.add(freePlantDatumDto);
        FreePlantRootDto givenFreePlantDto = new FreePlantRootDto();
        givenFreePlantDto.setData(datumList);

        Plant receivedPlant = plantMapper.mapToPlant(givenFreePlantDto);

        Plant expectedPlant = new Plant("Plant scientific name", "Plant common name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);

        //THEN
        assertEquals(expectedPlant.getPlantScientificName(), receivedPlant.getPlantScientificName());
        assertEquals(expectedPlant.getPlantCommonName(), receivedPlant.getPlantCommonName());
        assertEquals(expectedPlant.getPlantSunlight(), receivedPlant.getPlantSunlight());
        assertEquals(expectedPlant.getPlantWatering(), receivedPlant.getPlantWatering());

    }

    @Test
    void mapToPlantDtoTest() {
        //GIVEN
        PlantMapper plantMapper = new PlantMapper();

        //WHEN
        Plant givenPlant = new Plant("Plant scientific name", "Plant common name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);

        PlantDto receivedPlantDto = plantMapper.mapToPlantDto(givenPlant);

        PlantDto expectedPlantDto = new PlantDto("Plant scientific name", "Plant common name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);

        //THEN
        assertEquals(expectedPlantDto.getPlantScientificName(), receivedPlantDto.getPlantScientificName());
        assertEquals(expectedPlantDto.getPlantCommonName(), receivedPlantDto.getPlantCommonName());
        assertEquals(expectedPlantDto.getPlantSunlight(), receivedPlantDto.getPlantSunlight());
        assertEquals(expectedPlantDto.getPlantWatering(), receivedPlantDto.getPlantWatering());
    }

    @Test
    void mapToPlantDtoListTest() {
        //GIVEN
        PlantMapper plantMapper = new PlantMapper();

        //WHEN
        Plant givenPlant1 = new Plant("Plant scientific name1", "Plant common name1", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);
        Plant givenPlant2 = new Plant("Plant scientific name2", "Plant common name2", WateringOptions.AVERAGE, InsolationOptions.PART_SHADE);
        ArrayList<Plant> givenPlants = new ArrayList<>();
        givenPlants.add(givenPlant1);
        givenPlants.add(givenPlant2);

        List<PlantDto> receivedPlantDtos = plantMapper.mapToPlantDtoList(givenPlants);

        PlantDto expectedPlantDto1 = new PlantDto("Plant scientific name1", "Plant common name1", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);
        PlantDto expectedPlantDto2 = new PlantDto("Plant scientific name2", "Plant common name2", WateringOptions.AVERAGE, InsolationOptions.PART_SHADE);
        ArrayList<PlantDto> expectedPlantDtos = new ArrayList<>();
        expectedPlantDtos.add(expectedPlantDto1);
        expectedPlantDtos.add(expectedPlantDto2);

        //THEN
        for(int i=0; i<expectedPlantDtos.size(); i++) {
            assertEquals(expectedPlantDtos.get(i).getPlantScientificName(), receivedPlantDtos.get(i).getPlantScientificName());
            assertEquals(expectedPlantDtos.get(i).getPlantCommonName(), receivedPlantDtos.get(i).getPlantCommonName());
            assertEquals(expectedPlantDtos.get(i).getPlantSunlight(), receivedPlantDtos.get(i).getPlantSunlight());
            assertEquals(expectedPlantDtos.get(i).getPlantWatering(), receivedPlantDtos.get(i).getPlantWatering());
        }
    }
}