package com.growkeeper.weatherDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    @JsonProperty("main")
    Main main;

    @JsonProperty("weather")
    ArrayList<Weather> weather;

    @JsonProperty("clouds")
    Clouds clouds;

    @JsonProperty("wind")
    Wind wind;

    @JsonProperty("rain")
    Rain rain;

    @JsonProperty("dt_txt")
    String dt_txt;
}
