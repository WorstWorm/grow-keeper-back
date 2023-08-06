package com.growkeeper.dto.api.freePlantDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantRootDto {
    @JsonProperty("data")
    ArrayList<FreePlantDatumDto> data;

    @JsonProperty("to")
    int myto;

    @JsonProperty("per_page")
    int per_page;

    @JsonProperty("current_page")
    int current_page;

    @JsonProperty("from")
    int from;

    @JsonProperty("last_page")
    int last_page;

    @JsonProperty("total")
    int total;

    @JsonProperty("default_image")
    FreePlantDefaultImageDto default_image;
}
