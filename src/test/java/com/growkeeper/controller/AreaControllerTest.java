package com.growkeeper.controller;

import com.growkeeper.domain.Area;
import com.growkeeper.dto.AreaDto;
import com.growkeeper.exception.AreaNotFoundException;
import com.growkeeper.mapper.AreaMapper;
import com.growkeeper.service.AreaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AreaControllerTest {

    @Mock
    private AreaService areaService;

    @Mock
    private AreaMapper areaMapper;

    @InjectMocks
    private AreaController areaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAreasTest() {
        //GIVEN
        List<AreaDto> expectedAreas = new ArrayList<>();
        when(areaService.getAreas()).thenReturn(new ArrayList<>());
        when(areaMapper.mapToAreaDtoList(new ArrayList<>())).thenReturn(expectedAreas);

        //WHEN
        ResponseEntity<List<AreaDto>> response = areaController.getAreas();

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAreas, response.getBody());
    }

    @Test
    void getAreaTest() throws AreaNotFoundException {
        //GIVEN
        int areaId = 1;
        AreaDto expectedAreaDto = new AreaDto();
        when(areaService.getArea(areaId)).thenReturn(new Area()); // Tutaj zwracamy obiekt Area, który zostanie zmapowany na expectedAreaDto
        when(areaMapper.mapToAreaDto(any(Area.class))).thenReturn(expectedAreaDto);

        //WHEN
        ResponseEntity<AreaDto> response = areaController.getArea(areaId);

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAreaDto, response.getBody());
    }

    @Test
    void createEmptyAreaTest() {
        //WHEN
        ResponseEntity<Void> response = areaController.createEmptyArea();

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(areaService, times(1)).createArea();
    }

    @Test
    void deleteAreaTest() throws AreaNotFoundException {
        //GIVEN
        int areaId = 1;

        //WHEN
        ResponseEntity<Void> response = areaController.deleteArea(areaId);

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(areaService, times(1)).deleteArea(areaId);
    }
}