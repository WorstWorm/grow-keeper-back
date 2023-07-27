package com.growkeeper.clients;

import com.growkeeper.config.FreePlantConfig;
import com.growkeeper.dto.FreePlantBasicsPlantDto;
import com.growkeeper.dto.FreePlantDetailedPlantDto;
import com.growkeeper.dto.PlantDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FreePlantClient {
    private final FreePlantConfig freePlantConfig;
    private final RestTemplate restTemplate;

    private URI buildUrlForIdSearch(String plantScientificName) {
        return UriComponentsBuilder.fromHttpUrl(freePlantConfig.getFreeplantApiEndpoint() + "/species-list")
                .queryParam("key", freePlantConfig.getFreeplantApiKey())
                .queryParam("q", plantScientificName)
                .build().encode().toUri();
    }

    private URI buildUrlForPlantDetails(int freeplantId) {
        return UriComponentsBuilder.fromHttpUrl(freePlantConfig.getFreeplantApiEndpoint() + "/species/details/" + freeplantId)
                .queryParam("key", freePlantConfig.getFreeplantApiKey())
                .build().encode().toUri();
    }

    public FreePlantDetailedPlantDto getPlantDetailsFromFreeplant(String plantScientificName) {
        FreePlantBasicsPlantDto[] listOfPlantIdByScientificName = restTemplate.getForObject(buildUrlForIdSearch(plantScientificName), FreePlantBasicsPlantDto[].class);
//        FreePlantBasicsPlantDto[] listOfPlantIdByScientificName = restTemplate.getForObject("https://perenual.com/api/species-list?key=sk-izWf64c24136c5e831634&q=Solanum lycopersicum", FreePlantBasicsPlantDto[].class);
        System.out.println("first request done");
        return restTemplate.getForObject(buildUrlForPlantDetails(listOfPlantIdByScientificName[0].getPlantId()), FreePlantDetailedPlantDto.class);
    }
}
