package com.growkeeper.dto;

import com.growkeeper.enums.InsolationOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AreaDto {

    private Integer areaId;
    private InsolationOptions areaInsolation;
    private Boolean areaCovered;
    private String areaScientificName;

    public AreaDto(Integer areaId, InsolationOptions areaInsolation, Boolean areaCovered) {
        this.areaId = areaId;
        this.areaInsolation = areaInsolation;
        this.areaCovered = areaCovered;
        this.areaScientificName = " ";
    }
}
