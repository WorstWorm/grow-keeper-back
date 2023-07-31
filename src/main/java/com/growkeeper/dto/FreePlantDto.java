package com.growkeeper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("common_name")
    private String common_name;

    @JsonProperty("scientific_name")
    private String[] scientific_name;

    @JsonProperty("watering")
    private String watering;

    @JsonProperty("sunlight")
    private String[] sunlight;
}
