package com.growkeeper.dto.api.openWeatherDto.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherListDto {

    @JsonProperty("main")
    OpenWeatherMainDto openWeatherMainDto;

    @JsonProperty("weather")
    ArrayList<OpenWeatherWeatherDto> openWeatherWeatherDto;

    @JsonProperty("clouds")
    OpenWeatherCloudsDto openWeatherCloudsDto;

    @JsonProperty("wind")
    OpenWeatherWindDto openWeatherWindDto;

    @JsonProperty("rain")
    OpenWeatherRainDto openWeatherRainDto;

    @JsonProperty("dt_txt")
    String dt_txt;
}
