package com.growkeeper.controller;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.PlantDto;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.mapper.PlantMapper;
import com.growkeeper.service.PlantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PlantControllerTest {

    @Mock
    private PlantService plantService;

    @Mock
    private PlantMapper plantMapper;

    @InjectMocks
    private PlantController plantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPlantsTest() {
        //GIVEN
        List<Plant> expectedPlants = new ArrayList<>();
        List<PlantDto> expectedPlantDtos = new ArrayList<>();
        when(plantService.getPlants()).thenReturn(expectedPlants);
        when(plantMapper.mapToPlantDtoList(expectedPlants)).thenReturn(expectedPlantDtos);

        //WHEN
        ResponseEntity<List<PlantDto>> response = plantController.getPlants();

        //THEN
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedPlantDtos, response.getBody());
    }

    @Test
    void getPlantTest() throws PlantNotFoundException {
        //GIVEN
        String plantScientificName = "SamplePlant";
        PlantDto expectedPlantDto = new PlantDto();
        when(plantService.getPlant(plantScientificName)).thenReturn(new Plant());
        when(plantMapper.mapToPlantDto(any())).thenReturn(expectedPlantDto);

        //WHEN
        ResponseEntity<PlantDto> response = plantController.getPlant(plantScientificName);

        //THEN
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedPlantDto, response.getBody());
    }

    @Test
    void getPlantNotFoundTest() throws PlantNotFoundException {
        //GIVEN
        String plantScientificName = "NonExistentPlant";
        when(plantService.getPlant(plantScientificName)).thenThrow(new PlantNotFoundException());

        //WHEN-THEN
        try {
            plantController.getPlant(plantScientificName);
        } catch (PlantNotFoundException e) {
            Assertions.assertEquals(PlantNotFoundException.class, e.getClass());
        }
    }
}
