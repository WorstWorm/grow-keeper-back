package com.growkeeper.domain;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantTest {
    @Test
    void plantConstructorAndGettersTest() {
        //GIVEN
        String scientificName = "Scientific plant name";
        String commonName = "Plant common name";
        WateringOptions wateringOption = WateringOptions.FREQUENT;
        InsolationOptions insolationOption = InsolationOptions.FULL_SUN;

        //WHEN
        Plant plant = new Plant(scientificName, commonName, wateringOption, insolationOption);

        //THEN
        assertEquals(scientificName, plant.getPlantScientificName());
        assertEquals(commonName, plant.getPlantCommonName());
        assertEquals(wateringOption, plant.getPlantWatering());
        assertEquals(insolationOption, plant.getPlantSunlight());
    }

    @Test
    void plantSettersTest() {
        //GIVEN
        Plant plant = new Plant();

        String scientificName = "Scientific plant name";
        String commonName = "Plant common name";
        WateringOptions wateringOption = WateringOptions.FREQUENT;
        InsolationOptions insolationOption = InsolationOptions.FULL_SUN;

        //WHEN
        plant.setPlantScientificName(scientificName);
        plant.setPlantCommonName(commonName);
        plant.setPlantWatering(wateringOption);
        plant.setPlantSunlight(insolationOption);

        //THEN
        assertEquals(scientificName, plant.getPlantScientificName());
        assertEquals(commonName, plant.getPlantCommonName());
        assertEquals(wateringOption, plant.getPlantWatering());
        assertEquals(insolationOption, plant.getPlantSunlight());
    }
}