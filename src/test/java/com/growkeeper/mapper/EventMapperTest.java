package com.growkeeper.mapper;

import com.growkeeper.domain.Event;
import com.growkeeper.dto.EventDto;
import com.growkeeper.enums.ActionOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class EventMapperTest {

    @Test
    void mapToEvent() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        EventDto givenEventDto = new EventDto(1, ActionOptions.WATER, LocalDate.of(2020, 1, 5));

        Event receivedEvent = eventMapper.mapToEvent(givenEventDto);

        Event expectedEvent = new Event(1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), false);

        //THEN
        Assertions.assertEquals(expectedEvent.getId(), receivedEvent.getId());
        Assertions.assertEquals(expectedEvent.getArea(), receivedEvent.getArea());
        Assertions.assertEquals(expectedEvent.getActionType(), receivedEvent.getActionType());
        Assertions.assertEquals(expectedEvent.getCompletionTime(), receivedEvent.getCompletionTime());
        Assertions.assertEquals(expectedEvent.isCompleted(), receivedEvent.isCompleted());
    }

    @Test
    void mapToEventDto() {
        //GIVEN
        EventMapper eventMapper = new EventMapper();

        //WHEN
        Event givenEvent = new Event(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);

        EventDto receivedEventDto = eventMapper.mapToEventDto(givenEvent);

        EventDto expectedEventDto = new EventDto(1, 1, ActionOptions.WATER, LocalDate.of(2020, 1, 5), true);

        //THEN
        Assertions.assertEquals(expectedEventDto.getId(), receivedEventDto.getId());
        Assertions.assertEquals(expectedEventDto.getArea(), receivedEventDto.getArea());
        Assertions.assertEquals(expectedEventDto.getActionType(), receivedEventDto.getActionType());
        Assertions.assertEquals(expectedEventDto.getCompletionTime(), receivedEventDto.getCompletionTime());
        Assertions.assertEquals(expectedEventDto.isCompleted(), receivedEventDto.isCompleted());
    }

    @Test
    void mapToEventList() {
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
            Assertions.assertEquals(expectedEvents.get(i).getId(), receivedEvents.get(i).getId());
            Assertions.assertEquals(expectedEvents.get(i).getArea(), receivedEvents.get(i).getArea());
            Assertions.assertEquals(expectedEvents.get(i).getActionType(), receivedEvents.get(i).getActionType());
            Assertions.assertEquals(expectedEvents.get(i).getCompletionTime(), receivedEvents.get(i).getCompletionTime());
            Assertions.assertEquals(expectedEvents.get(i).isCompleted(), receivedEvents.get(i).isCompleted());
        }
    }

    @Test
    void mapToEventDtoList() {
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
            Assertions.assertEquals(expectedEventDtos.get(i).getId(), receivedEventDtos.get(i).getId());
            Assertions.assertEquals(expectedEventDtos.get(i).getArea(), receivedEventDtos.get(i).getArea());
            Assertions.assertEquals(expectedEventDtos.get(i).getActionType(), receivedEventDtos.get(i).getActionType());
            Assertions.assertEquals(expectedEventDtos.get(i).getCompletionTime(), receivedEventDtos.get(i).getCompletionTime());
            Assertions.assertEquals(expectedEventDtos.get(i).isCompleted(), receivedEventDtos.get(i).isCompleted());
        }
    }
}