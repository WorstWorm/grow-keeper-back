package com.growkeeper.domain;

import com.growkeeper.enums.InsolationOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaTest {

    @Test
    void areaConstructorAndGettersTest() {
        //GIVEN
        Integer areaId = 1;
        InsolationOptions areaInsolation = InsolationOptions.FULL_SUN;
        Boolean areaCovered = true;
        String areaScientificName = "ScientificName";

        //WHEN
        Area area = new Area(1, areaInsolation, areaCovered, areaScientificName);

        //THEN
        assertEquals(areaId, area.getAreaId());
        assertEquals(areaInsolation, area.getAreaInsolation());
        assertEquals(areaCovered, area.getAreaCovered());
        assertEquals(areaScientificName, area.getAreaScientificName());
    }

    @Test
    void areaSettersTest() {
        //GIVEN
        Area area = new Area();

        Integer areaId = 2;
        InsolationOptions areaInsolation = InsolationOptions.PART_SHADE;
        Boolean areaCovered = false;
        String areaScientificName = "NewScientificName";

        //WHEN
        area.setAreaId(areaId);
        area.setAreaInsolation(areaInsolation);
        area.setAreaCovered(areaCovered);
        area.setAreaScientificName(areaScientificName);

        //THEN
        assertEquals(areaId, area.getAreaId());
        assertEquals(areaInsolation, area.getAreaInsolation());
        assertEquals(areaCovered, area.getAreaCovered());
        assertEquals(areaScientificName, area.getAreaScientificName());
    }
}
