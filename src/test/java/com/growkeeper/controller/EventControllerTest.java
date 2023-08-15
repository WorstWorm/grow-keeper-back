package com.growkeeper.controller;

import com.growkeeper.dto.EventDto;
import com.growkeeper.exception.EventNotFoundException;
import com.growkeeper.mapper.EventMapper;
import com.growkeeper.service.EventService;
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

class EventControllerTest {

    @Mock
    private EventService eventService;

    @Mock
    private EventMapper eventMapper;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEventsTest() {
        //GIVEN
        List<EventDto> expectedEvents = new ArrayList<>();
        when(eventService.getEvents()).thenReturn(new ArrayList<>());
        when(eventMapper.mapToEventDtoList(new ArrayList<>())).thenReturn(expectedEvents);

        //WHEN
        ResponseEntity<List<EventDto>> response = eventController.getEvents();

        //THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedEvents, response.getBody());
    }

    @Test
    void switchCompletedTest() throws EventNotFoundException {
        //GIVEN
        int eventId = 1;

        //WHEN
        eventController.switchCompleted(eventId);

        //THEN
        verify(eventService, times(1)).updateEvent(eventId);
    }
}
