package com.growkeeper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantDetailedPlantDto {
    @JsonProperty("scientific_name")
    private String plantScientificName;

    @JsonProperty("other_name")
    private String plantCommonName;

    @JsonProperty("watering")
    private String plantWatering;

    @JsonProperty("sunlight")
    private String plantSunlight;

    @JsonProperty("poisonous_to_humans")
    private int plantPoisonous;


}
