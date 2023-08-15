package com.growkeeper.service;

import com.growkeeper.domain.Event;
import com.growkeeper.enums.ActionOptions;
import com.growkeeper.exception.EventNotFoundException;
import com.growkeeper.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        eventService = new EventService(eventRepository);
    }

    @Test
    public void getEventsTest() {
        List<Event> expectedEvents = new ArrayList<>();
        expectedEvents.add(new Event(1, 1, ActionOptions.WIND_PROTECT, LocalDate.now(), false));
        expectedEvents.add(new Event(2, 2, ActionOptions.WATER, LocalDate.now(), true));
        when(eventRepository.findAll()).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEvents();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    public void updateEvent_EventFoundTest() {
        int eventId = 1;
        Event eventToUpdate = new Event(1, 1, ActionOptions.WIND_PROTECT, LocalDate.now(), false);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(eventToUpdate));
        when(eventRepository.save(eventToUpdate)).thenReturn(eventToUpdate);

        eventService.updateEvent(eventId);

        assertTrue(eventToUpdate.isCompleted());
        verify(eventRepository).findById(eventId);
        verify(eventRepository).save(eventToUpdate);
    }

    @Test
    public void updateEvent_EventNotFoundTest() {
        int eventId = 1;
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundException.class, () -> eventService.updateEvent(eventId));
    }

    @Test
    public void addEventsTest() {
        List<Event> newEvents = new ArrayList<>();
        newEvents.add(new Event(3, 3, ActionOptions.WATER, LocalDate.now(), false));
        newEvents.add(new Event(4, 4, ActionOptions.SUN_PROTECT, LocalDate.now(), true));
        doNothing().when(eventRepository).deleteAll();
        when(eventRepository.saveAll(newEvents)).thenReturn(newEvents);

        eventService.addEvents(newEvents);

        verify(eventRepository).deleteAll();
        verify(eventRepository).saveAll(newEvents);
    }
}
