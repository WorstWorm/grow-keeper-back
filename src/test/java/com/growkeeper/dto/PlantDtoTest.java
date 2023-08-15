package com.growkeeper.dto;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantDtoTest {
    @Test
    void plantDtoConstructorAndGettersTest() {
        //GIVEN
        String scientificName = "Scientific plantDto name";
        String commonName = "PlantDto common name";
        WateringOptions wateringOption = WateringOptions.FREQUENT;
        InsolationOptions insolationOption = InsolationOptions.FULL_SUN;

        //WHEN
        PlantDto plantDto = new PlantDto(scientificName, commonName, wateringOption, insolationOption);

        //THEN
        assertEquals(scientificName, plantDto.getPlantScientificName());
        assertEquals(commonName, plantDto.getPlantCommonName());
        assertEquals(wateringOption, plantDto.getPlantWatering());
        assertEquals(insolationOption, plantDto.getPlantSunlight());
    }

    @Test
    void plantDtoSettersTest() {
        //GIVEN
        PlantDto plantDto = new PlantDto();

        String scientificName = "Scientific plantDto name";
        String commonName = "PlantDto common name";
        WateringOptions wateringOption = WateringOptions.FREQUENT;
        InsolationOptions insolationOption = InsolationOptions.FULL_SUN;

        //WHEN
        plantDto.setPlantScientificName(scientificName);
        plantDto.setPlantCommonName(commonName);
        plantDto.setPlantWatering(wateringOption);
        plantDto.setPlantSunlight(insolationOption);

        //THEN
        assertEquals(scientificName, plantDto.getPlantScientificName());
        assertEquals(commonName, plantDto.getPlantCommonName());
        assertEquals(wateringOption, plantDto.getPlantWatering());
        assertEquals(insolationOption, plantDto.getPlantSunlight());
    }
}