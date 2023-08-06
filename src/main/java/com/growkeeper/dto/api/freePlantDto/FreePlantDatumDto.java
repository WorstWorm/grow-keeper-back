package com.growkeeper.dto.api.freePlantDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantDatumDto {
    @JsonProperty("id")
    int id;

    @JsonProperty("common_name")
    String common_name;

    @JsonProperty("scientific_name")
    ArrayList<String> scientific_name;

    @JsonProperty("cycle")
    String cycle;

    @JsonProperty("watering")
    String watering;

    @JsonProperty("sunlight")
    ArrayList<String> sunlight;
}
