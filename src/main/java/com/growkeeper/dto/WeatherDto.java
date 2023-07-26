package com.growkeeper.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherDto {

    private Integer weatherId;
    private Float weatherTemperatureAvrg;
    private Integer weatherClouds;
    private Float weatherWind;
    private String weatherType;
}
