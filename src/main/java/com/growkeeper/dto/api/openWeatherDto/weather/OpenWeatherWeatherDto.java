package com.growkeeper.dto.api.openWeatherDto.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherWeatherDto {
    @JsonProperty("main")
    String main;
}
