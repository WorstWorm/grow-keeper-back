package com.growkeeper.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "weather")
public class Weather {

    @Id
    @Column(name = "weather_id", unique = true)
    private Integer weatherId;

    @Column(name = "weather_temperature_avrg")
    private Float weatherTemperatureAvrg;

    @Column(name = "weather_clouds")
    private Integer weatherClouds;

    @Column(name = "weather_wind")
    private Float weatherWind;

    @Column(name = "weather_type")
    private String weatherType;
}
