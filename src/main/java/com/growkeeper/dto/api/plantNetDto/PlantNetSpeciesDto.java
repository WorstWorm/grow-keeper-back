package com.growkeeper.dto.api.plantNetDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlantNetSpeciesDto {
    @JsonProperty("scientificNameWithoutAuthor")
    String scientificNameWithoutAuthor;
//    @JsonProperty("commonNames")
//    ArrayList<String> commonNames;
}
