package com.growkeeper.dto;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.MoistureOptions;
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
    private MoistureOptions areaMoisture;
    private InsolationOptions areaInsolation;
    private Float areaLength;
    private Float areaWidth;
    private Float areaDepth;
    private String areaScientificName;
}
