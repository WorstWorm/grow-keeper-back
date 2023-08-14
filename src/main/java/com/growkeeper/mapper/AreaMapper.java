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
            areaDto.getAreaInsolation(),
            areaDto.getAreaCovered(),
            areaDto.getAreaScientificName()
        );
    }

    public AreaDto mapToAreaDto(final Area area) {
        return new AreaDto(
            area.getAreaId(),
            area.getAreaInsolation(),
            area.getAreaCovered(),
            area.getAreaScientificName()
        );
    }

    public List<AreaDto> mapToAreaDtoList(final List<Area> areaList) {
        return areaList.stream().map(this::mapToAreaDto).collect(Collectors.toList());
    }
}
