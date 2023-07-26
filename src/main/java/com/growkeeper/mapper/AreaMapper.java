package com.growkeeper.mapper;

import com.growkeeper.domain.Area;
import com.growkeeper.dto.AreaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaMapper {
    public Area mapToArea(final AreaDto areaDto) {
        return new Area(
            areaDto.getAreaId(),
            areaDto.getAreaMoisture(),
            areaDto.getAreaInsolation(),
            areaDto.getAreaLength(),
            areaDto.getAreaWidth(),
            areaDto.getAreaDepth(),
            areaDto.getAreaScientificName()
        );
    }

    public AreaDto mapToAreaDto(final Area area) {
        return new AreaDto(
            area.getAreaId(),
            area.getAreaMoisture(),
            area.getAreaInsolation(),
            area.getAreaLength(),
            area.getAreaWidth(),
            area.getAreaDepth(),
            area.getAreaScientificName()
        );
    }

    public List<Area> mapToAreaList(final List<AreaDto> areaDtoList) {
        return areaDtoList.stream().map(this::mapToArea).collect(Collectors.toList());
    }

    public List<AreaDto> mapToAreaDtoList(final List<Area> areaList) {
        return areaList.stream().map(this::mapToAreaDto).collect(Collectors.toList());
    }
}
