package com.growkeeper.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WateringParametersConfig {

    @Value("${watering.frequent}")
    private int frequent;

    @Value("${watering.average}")
    private int average;

    @Value("${watering.minimum}")
    private int minimum;

    @Value("${watering.none}")
    private int none;
}
