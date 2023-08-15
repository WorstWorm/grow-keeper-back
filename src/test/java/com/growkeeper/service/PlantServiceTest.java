package com.growkeeper.service;

import com.growkeeper.domain.Plant;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.repository.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlantServiceTest {

    @Mock
    private PlantRepository plantRepository;

    private PlantService plantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        plantService = new PlantService(plantRepository);
    }

    @Test
    public void getPlant_SuccessTest() {
        String plantScientificName = "Rose";
        Plant mockPlant = new Plant(plantScientificName, "Common plant name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);
        when(plantRepository.findById(plantScientificName)).thenReturn(Optional.of(mockPlant));

        Plant result = plantService.getPlant(plantScientificName);

        assertNotNull(result);
        assertEquals(plantScientificName, result.getPlantScientificName());
    }

    @Test
    public void getPlant_NotFoundTest() {
        String nonExistentPlantName = "NonExistentPlant";
        when(plantRepository.findById(nonExistentPlantName)).thenReturn(Optional.empty());

        assertThrows(PlantNotFoundException.class, () -> plantService.getPlant(nonExistentPlantName));
    }

    @Test
    public void addPlant_AlreadyExistsTest() {
        String existingPlantName = "Rose";
        Plant mockPlant = new Plant(existingPlantName, "Common plant name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);
        when(plantRepository.findById(existingPlantName)).thenReturn(Optional.of(mockPlant));

        plantService.addPlant(mockPlant);

        verify(plantRepository, times(1)).deleteById(existingPlantName);
        verify(plantRepository, times(1)).save(mockPlant);
    }

    @Test
    public void addPlant_NewPlantTest() {
        String newPlantName = "Tulip";
        Plant mockPlant = new Plant(newPlantName, "Common plant name", WateringOptions.FREQUENT, InsolationOptions.FULL_SUN);
        when(plantRepository.findById(newPlantName)).thenReturn(Optional.empty());

        plantService.addPlant(mockPlant);

        verify(plantRepository, never()).deleteById(any());
        verify(plantRepository, times(1)).save(mockPlant);
    }

    @Test
    public void deletePlant_SuccessTest() {
        String plantScientificName = "Rose";
        when(plantRepository.findById(plantScientificName)).thenReturn(Optional.of(new Plant()));

        plantService.deletePlant(plantScientificName);

        verify(plantRepository, times(1)).deleteById(plantScientificName);
    }

    @Test
    public void deletePlant_NotFoundTest() {
        String nonExistentPlantName = "NonExistentPlant";
        when(plantRepository.findById(nonExistentPlantName)).thenReturn(Optional.empty());

        assertThrows(PlantNotFoundException.class, () -> plantService.deletePlant(nonExistentPlantName));
        verify(plantRepository, never()).deleteById(any());
    }
}
