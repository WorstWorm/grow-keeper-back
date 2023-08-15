package com.growkeeper.mapper;

import com.growkeeper.domain.Event;
import com.growkeeper.dto.EventDto;
import com.growkeeper.enums.ActionOptions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventMapperTest {

    @Test
    void mapToEventTest() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        EventDto givenEventDto = new EventDto(1, ActionOptions.WATER, LocalDate.of(2020, 1, 5));

        Event receivedEvent = eventMapper.mapToEvent(givenEventDto);

        Event expectedEvent = new Event(1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), false);

        //THEN
        assertEquals(expectedEvent.getId(), receivedEvent.getId());
        assertEquals(expectedEvent.getArea(), receivedEvent.getArea());
        assertEquals(expectedEvent.getActionType(), receivedEvent.getActionType());
        assertEquals(expectedEvent.getCompletionTime(), receivedEvent.getCompletionTime());
        assertEquals(expectedEvent.isCompleted(), receivedEvent.isCompleted());
    }

    @Test
    void mapToEventDtoTest() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        Event givenEvent = new Event(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);

        EventDto receivedEventDto = eventMapper.mapToEventDto(givenEvent);

        EventDto expectedEventDto = new EventDto(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);

        //THEN
        assertEquals(expectedEventDto.getId(), receivedEventDto.getId());
        assertEquals(expectedEventDto.getArea(), receivedEventDto.getArea());
        assertEquals(expectedEventDto.getActionType(), receivedEventDto.getActionType());
        assertEquals(expectedEventDto.getCompletionTime(), receivedEventDto.getCompletionTime());
        assertEquals(expectedEventDto.isCompleted(), receivedEventDto.isCompleted());
    }

    @Test
    void mapToEventListTest() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        EventDto givenEventDto1 = new EventDto(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);
        EventDto givenEventDto2 = new EventDto(3, 3, ActionOptions.WIND_PROTECT, LocalDate.of(2022, 2, 10), false);
        ArrayList<EventDto> givenEventDtos = new ArrayList<>();
        givenEventDtos.add(givenEventDto1);
        givenEventDtos.add(givenEventDto2);

        List<Event> receivedEvents = eventMapper.mapToEventList(givenEventDtos);

        Event expectedEvent1 = new Event(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);
        Event expectedEvent2 = new Event(3, 3, ActionOptions.WIND_PROTECT, LocalDate.of(2022, 2, 10), false);
        ArrayList<Event> expectedEvents = new ArrayList<>();
        expectedEvents.add(expectedEvent1);
        expectedEvents.add(expectedEvent2);

        //THEN
        for(int i=0; i<expectedEvents.size(); i++) {
            assertEquals(expectedEvents.get(i).getId(), receivedEvents.get(i).getId());
            assertEquals(expectedEvents.get(i).getArea(), receivedEvents.get(i).getArea());
            assertEquals(expectedEvents.get(i).getActionType(), receivedEvents.get(i).getActionType());
            assertEquals(expectedEvents.get(i).getCompletionTime(), receivedEvents.get(i).getCompletionTime());
            assertEquals(expectedEvents.get(i).isCompleted(), receivedEvents.get(i).isCompleted());
        }
    }

    @Test
    void mapToEventDtoListTest() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        Event givenEvent1 = new Event(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);
        Event givenEvent2 = new Event(3, 3, ActionOptions.WIND_PROTECT, LocalDate.of(2022, 2, 10), false);
        ArrayList<Event> givenEvents = new ArrayList<>();
        givenEvents.add(givenEvent1);
        givenEvents.add(givenEvent2);

        List<EventDto> receivedEventDtos = eventMapper.mapToEventDtoList(givenEvents);

        EventDto expectedEventDto1 = new EventDto(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);
        EventDto expectedEventDto2 = new EventDto(3, 3, ActionOptions.WIND_PROTECT, LocalDate.of(2022, 2, 10), false);
        ArrayList<EventDto> expectedEventDtos = new ArrayList<>();
        expectedEventDtos.add(expectedEventDto1);
        expectedEventDtos.add(expectedEventDto2);

        //THEN
        for(int i=0; i<expectedEventDtos.size(); i++) {
            assertEquals(expectedEventDtos.get(i).getId(), receivedEventDtos.get(i).getId());
            assertEquals(expectedEventDtos.get(i).getArea(), receivedEventDtos.get(i).getArea());
            assertEquals(expectedEventDtos.get(i).getActionType(), receivedEventDtos.get(i).getActionType());
            assertEquals(expectedEventDtos.get(i).getCompletionTime(), receivedEventDtos.get(i).getCompletionTime());
            assertEquals(expectedEventDtos.get(i).isCompleted(), receivedEventDtos.get(i).isCompleted());
        }
    }
}