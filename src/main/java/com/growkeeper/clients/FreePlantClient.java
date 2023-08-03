package com.growkeeper.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.growkeeper.config.FreePlantConfig;
import com.growkeeper.dto.FreePlantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class FreePlantClient {
    private final FreePlantConfig freePlantConfig;
    private final RestTemplate restTemplate;

    private URI buildUrl(String plantName) {
        return UriComponentsBuilder.fromHttpUrl(freePlantConfig.getFreeplantApiEndpoint() + "/species-list")
                .queryParam("key", freePlantConfig.getFreeplantApiKey())
                .queryParam("q", plantName)
                .build().encode().toUri();
    }

    public void getId(String name) throws JsonProcessingException {
        String data = restTemplate.getForObject(buildUrl(name), String.class);
        data = data.substring((data.indexOf("[")+1), (data.lastIndexOf(",\"default")));
        data += "}";
        ObjectMapper objectMapper = new ObjectMapper();
        FreePlantDto plant = objectMapper.readValue(data, FreePlantDto.class);
        System.out.println(plant.getCommon_name() + " - " + plant.getScientific_name()[0] + " - " + plant.getSunlight()[0] + "/" + plant.getWatering());
    }
}