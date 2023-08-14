package com.growkeeper.mapper;

import com.growkeeper.domain.Area;
import com.growkeeper.dto.AreaDto;
import com.growkeeper.enums.InsolationOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AreaMapperTest {

    private List<AreaDto> generateAreaDtoList() {
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaDtoList.add(new AreaDto(0, InsolationOptions.FULL_SUN, true, "Example Plant1"));
        areaDtoList.add(new AreaDto(1, InsolationOptions.SUN_PART_SHADE, true, "Example Plant2"));
        areaDtoList.add(new AreaDto(2, InsolationOptions.PART_SHADE, true, "Example Plant3"));
        areaDtoList.add(new AreaDto(3, InsolationOptions.FULL_SUN_PARTIAL_SUN, true, "Example Plant4"));
        areaDtoList.add(new AreaDto(4, InsolationOptions.FULL_SHADE, true, "Example Plant5"));
        return areaDtoList;
    }

    private List<Area> generateAreaList() {
        List<Area> areaList = new ArrayList<>();
        areaList.add(new Area(0, InsolationOptions.FULL_SUN, true, "Example Plant1"));
        areaList.add(new Area(1, InsolationOptions.SUN_PART_SHADE, true, "Example Plant2"));
        areaList.add(new Area(2, InsolationOptions.PART_SHADE, true, "Example Plant3"));
        areaList.add(new Area(3, InsolationOptions.FULL_SUN_PARTIAL_SUN, true, "Example Plant4"));
        areaList.add(new Area(4, InsolationOptions.FULL_SHADE, true, "Example Plant5"));
        return areaList;
    }

    @Test
    void mapToArea_valid() {
        //Given
        AreaMapper areaMapper = new AreaMapper();

        //When
        Area givenArea = generateAreaList().get(0);
        AreaDto receivedAreaDto = areaMapper.mapToAreaDto(givenArea);

        //Then
        Assertions.assertEquals(generateAreaDtoList().get(0).getAreaId(), receivedAreaDto.getAreaId());
        Assertions.assertEquals(generateAreaDtoList().get(0).getAreaScientificName(), receivedAreaDto.getAreaScientificName());
        Assertions.assertEquals(generateAreaDtoList().get(0).getAreaInsolation(), receivedAreaDto.getAreaInsolation());
        Assertions.assertEquals(generateAreaDtoList().get(0).getAreaCovered(), receivedAreaDto.getAreaCovered());
    }

    @Test
    void mapToAreaDto_valid() {
        //Given
        AreaMapper areaMapper = new AreaMapper();

        //When
        AreaDto givenAreaDto = generateAreaDtoList().get(0);
        Area receivedArea = areaMapper.mapToArea(givenAreaDto);

        //Then
        Assertions.assertEquals(generateAreaList().get(0).getAreaId(), receivedArea.getAreaId());
        Assertions.assertEquals(generateAreaList().get(0).getAreaScientificName(), receivedArea.getAreaScientificName());
        Assertions.assertEquals(generateAreaList().get(0).getAreaInsolation(), receivedArea.getAreaInsolation());
        Assertions.assertEquals(generateAreaList().get(0).getAreaCovered(), receivedArea.getAreaCovered());
    }

    @Test
    void mapToAreaDtoList_valid() {
        //Given
        AreaMapper areaMapper = new AreaMapper();

        //When
        List<Area> givenAreas = generateAreaList();
        List<AreaDto> receivedAreaDtos = areaMapper.mapToAreaDtoList(givenAreas);

        //Then
        for(int i=0; i<receivedAreaDtos.size(); i++) {
            Assertions.assertEquals(generateAreaDtoList().get(i).getAreaId(), receivedAreaDtos.get(i).getAreaId());
            Assertions.assertEquals(generateAreaDtoList().get(i).getAreaScientificName(), receivedAreaDtos.get(i).getAreaScientificName());
            Assertions.assertEquals(generateAreaDtoList().get(i).getAreaInsolation(), receivedAreaDtos.get(i).getAreaInsolation());
            Assertions.assertEquals(generateAreaDtoList().get(i).getAreaCovered(), receivedAreaDtos.get(i).getAreaCovered());
        }
    }
}