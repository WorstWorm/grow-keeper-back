package com.growkeeper.clients;

import com.growkeeper.config.FreePlantConfig;
import com.growkeeper.dto.api.freePlantDto.FreePlantRootDto;
import com.growkeeper.service.PlantService;
import com.growkeeper.mapper.PlantMapper;
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
    private final PlantService plantService;
    private final PlantMapper plantMapper;

    private URI buildUrl(String plantName) {
        return UriComponentsBuilder.fromHttpUrl(freePlantConfig.getFreeplantApiEndpoint() + "/species-list")
                .queryParam("key", freePlantConfig.getFreeplantApiKey())
                .queryParam("q", plantName)
                .build().encode().toUri();
    }

    public void getId(String name) {
        FreePlantRootDto freePlantRootDto = restTemplate.getForObject(buildUrl(name), FreePlantRootDto.class);
        plantService.addPlant(plantMapper.mapToPlant(freePlantRootDto));
    }
}