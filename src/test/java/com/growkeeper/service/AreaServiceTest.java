package com.growkeeper.service;

import com.growkeeper.clients.FreePlantClient;
import com.growkeeper.domain.Area;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.repository.AreaRepository;
import com.growkeeper.repository.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AreaServiceTest {

    @Mock
    private AreaRepository areaRepository;

    @Mock
    private PlantRepository plantRepository;

    @Mock
    private FreePlantClient freePlantClient;

    private AreaService areaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        areaService = new AreaService(areaRepository, plantRepository, freePlantClient);
    }

    @Test
    public void getArea_AreaFoundTest() {
        int areaId = 1;
        Area expectedArea = new Area();
        when(areaRepository.findById(areaId)).thenReturn(Optional.of(expectedArea));

        Area actualArea = areaService.getArea(areaId);

        assertEquals(expectedArea, actualArea);
    }

    @Test
    public void getArea_AreaNotFoundTest() {
        int areaId = 1;
        when(areaRepository.findById(areaId)).thenReturn(Optional.empty());

        assertThrows(AreaNotFoundException.class, () -> areaService.getArea(areaId));
    }

    @Test
    public void getAreasTest() {
        List<Area> expectedAreas = new ArrayList<>();
        expectedAreas.add(new Area());
        expectedAreas.add(new Area());
        when(areaRepository.findAll()).thenReturn(expectedAreas);

        List<Area> actualAreas = areaService.getAreas();

        assertEquals(expectedAreas, actualAreas);
    }

    @Test
    public void deleteArea_AreaFoundTest() {
        int areaId = 1;
        Area areaToDelete = new Area();
        when(areaRepository.findById(areaId)).thenReturn(Optional.of(areaToDelete));
        doNothing().when(areaRepository).deleteById(areaId);

        areaService.deleteArea(areaId);

        verify(areaRepository).deleteById(areaId);
    }

    @Test
    public void deleteArea_AreaNotFoundTest() {
        int areaId = 1;
        when(areaRepository.findById(areaId)).thenReturn(Optional.empty());

        assertThrows(AreaNotFoundException.class, () -> areaService.deleteArea(areaId));
        verify(areaRepository, never()).deleteById(any());
    }
}
