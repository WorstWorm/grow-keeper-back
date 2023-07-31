package com.growkeeper.dto;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlantDto {

    private String plantScientificName;
    private String plantCommonName;
    private WateringOptions plantWatering;
    private InsolationOptions plantSunlight;
}
