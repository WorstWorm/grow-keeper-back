package com.growkeeper.clients;

import com.growkeeper.config.FreePlantConfig;
import com.growkeeper.dto.api.freePlantDto.FreePlantRootDto;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.mapper.PlantMapper;
import com.growkeeper.service.PlantService;
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

    private URI buildUrlToGetPlane(String plantName) {
        return UriComponentsBuilder.fromHttpUrl(freePlantConfig.getFreeplantApiEndpoint() + "/species-list")
                .queryParam("key", freePlantConfig.getFreeplantApiKey())
                .queryParam("q", plantName)
                .build().encode().toUri();
    }

    public void getPlantInfo(String plantName) {
        FreePlantRootDto freePlantRootDto = restTemplate.getForObject(buildUrlToGetPlane(plantName), FreePlantRootDto.class);
        if(freePlantRootDto != null) {
            plantService.addPlant(plantMapper.mapToPlant(freePlantRootDto));
        } else {
            throw new PlantNotFoundException();
        }
    }
}