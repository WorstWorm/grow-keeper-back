package com.growkeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherDto {
    private Double weatherTemperature;
    private String weatherType;
    private Integer weatherClouds;
    private Double weatherWind;
    private Double weatherRain;
    private LocalDateTime weatherTime;
}
