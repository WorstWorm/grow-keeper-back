package com.growkeeper.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "weather")
public class Weather implements Comparable<Weather> {

    @Column(name = "weather_temperature")
    private Double weatherTemperature;

    @Column(name = "weather_type")
    private String weatherType;

    @Column(name = "weather_clouds")
    private Integer weatherClouds;

    @Column(name = "weather_wind")
    private Double weatherWind;

    @Column(name = "weather_rain")
    private Double weatherRain;

    @Id
    @Column(name = "weather_time", unique = true)
    private LocalDateTime weatherTime;

    @Override
    public int compareTo(Weather weather) {
        return this.weatherTime.compareTo(weather.weatherTime);
    }
}
