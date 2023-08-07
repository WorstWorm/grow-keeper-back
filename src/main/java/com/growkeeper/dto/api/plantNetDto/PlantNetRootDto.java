package com.growkeeper.dto.api.plantNetDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlantNetRootDto {
    @JsonProperty("results")
    ArrayList<PlantNetResultDto> results;
}
