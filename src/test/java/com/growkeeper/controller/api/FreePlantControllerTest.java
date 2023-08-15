package com.growkeeper.controller.api;

import com.growkeeper.service.api.FreePlantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class FreePlantControllerTest {

    @Mock
    private FreePlantService freePlantService;

    @InjectMocks
    private FreePlantController freePlantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getInfoTest() {
        //GIVEN
        String plantName = "SamplePlant";
        doNothing().when(freePlantService).getInfo(plantName);

        //WHEN
        freePlantController.getInfo(plantName);

        //THEN
        verify(freePlantService, times(1)).getInfo(plantName);
    }
}
