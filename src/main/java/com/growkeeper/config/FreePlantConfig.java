package com.growkeeper.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FreePlantConfig {

    @Value("${freeplant.api.endpoint.prod}")
    private String freeplantApiEndpoint;
    @Value("${freeplant.api.key}")
    private String freeplantApiKey;
}
