package com.growkeeper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Data
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherObjectDto {
    @JsonProperty("main")
    private String[] main;

    @JsonProperty("weather")
    private String[] weather;

    @JsonProperty("clouds")
    private String[] clouds;

    @JsonProperty("wind")
    private String[] wind;

    @Override
    public String toString() {
        return "OpenWeatherObjectDto{" +
                "main=" + Arrays.toString(main) +
                ", weather=" + Arrays.toString(weather) +
                ", clouds=" + Arrays.toString(clouds) +
                ", wind=" + Arrays.toString(wind) +
                '}';
    }
}
