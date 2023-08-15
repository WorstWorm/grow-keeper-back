package com.growkeeper.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class PlantNetConfig {

    @Value("${plantnet.api.endpoint}")
    private String plantnetApiEndpoint;

    @Value("${plantnet.api.key}")
    private String plantnetApiKey;
}
