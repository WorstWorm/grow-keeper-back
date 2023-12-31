package com.growkeeper.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class FreePlantConfig {

    @Value("${freeplant.api.endpoint}")
    private String freeplantApiEndpoint;

    @Value("${freeplant.api.key}")
    private String freeplantApiKey;
}
