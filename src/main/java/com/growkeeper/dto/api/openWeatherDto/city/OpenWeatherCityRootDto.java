package com.growkeeper.dto.api.openWeatherDto.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherCityRootDto {
    @JsonProperty("name")
    String name;

    @JsonProperty("local_names")
    OpenWeatherLocalNamesDto local_names;

    @JsonProperty("lat")
    double lat;

    @JsonProperty("lon")
    double lon;

    @JsonProperty("country")
    String country;

    @JsonProperty("state")
    String state;
}
