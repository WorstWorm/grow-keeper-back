package com.growkeeper.controller.api;

import com.growkeeper.service.api.PlantNetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlantNetControllerTest {

    @Mock
    private PlantNetService plantNetService;

    @InjectMocks
    private PlantNetController plantNetController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void uploadImageTest() {
        // GIVEN
        MultipartFile plantImage = mock(MultipartFile.class);
        String expectedPlantName = "Sample Plant";

        when(plantNetService.getPlantName(plantImage)).thenReturn(expectedPlantName);

        // WHEN
        ResponseEntity<String> response = plantNetController.uploadImage(plantImage);

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPlantName, response.getBody());
        verify(plantNetService, times(1)).getPlantName(plantImage);
    }
}
