package com.growkeeper.dto;

import com.growkeeper.enums.InsolationOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaDtoTest {

    @Test
    void areaDtoConstructorAndGettersTest() {
        //GIVEN
        Integer areaDtoId = 1;
        InsolationOptions areaDtoInsolation = InsolationOptions.FULL_SUN;
        Boolean areaDtoCovered = true;
        String areaDtoScientificName = "ScientificName";

        //WHEN
        AreaDto areaDto = new AreaDto(1, areaDtoInsolation, areaDtoCovered, areaDtoScientificName);

        //THEN
        assertEquals(areaDtoId, areaDto.getAreaId());
        assertEquals(areaDtoInsolation, areaDto.getAreaInsolation());
        assertEquals(areaDtoCovered, areaDto.getAreaCovered());
        assertEquals(areaDtoScientificName, areaDto.getAreaScientificName());
    }

    @Test
    void areaDtoSettersTest() {
        //GIVEN
        AreaDto areaDto = new AreaDto();

        Integer areaDtoId = 2;
        InsolationOptions areaDtoInsolation = InsolationOptions.PART_SHADE;
        Boolean areaDtoCovered = false;
        String areaDtoScientificName = "NewScientificName";

        //WHEN
        areaDto.setAreaId(areaDtoId);
        areaDto.setAreaInsolation(areaDtoInsolation);
        areaDto.setAreaCovered(areaDtoCovered);
        areaDto.setAreaScientificName(areaDtoScientificName);

        //THEN
        assertEquals(areaDtoId, areaDto.getAreaId());
        assertEquals(areaDtoInsolation, areaDto.getAreaInsolation());
        assertEquals(areaDtoCovered, areaDto.getAreaCovered());
        assertEquals(areaDtoScientificName, areaDto.getAreaScientificName());
    }
}
