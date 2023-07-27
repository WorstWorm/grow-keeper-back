package com.growkeeper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantBasicsPlantDto {
    @JsonProperty("id")
    private int plantId;
}
