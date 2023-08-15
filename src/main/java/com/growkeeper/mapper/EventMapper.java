package com.growkeeper.mapper;

import com.growkeeper.domain.Event;
import com.growkeeper.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMapper {

    public Event mapToEvent(final EventDto eventDto) {
        return new Event(
                eventDto.getId(),
                eventDto.getArea(),
                eventDto.getActionType(),
                eventDto.getCompletionTime(),
                eventDto.isCompleted()
        );
    }

    public EventDto mapToEventDto(final Event event) {
        return new EventDto(
                event.getId(),
                event.getArea(),
                event.getActionType(),
                event.getCompletionTime(),
                event.isCompleted()
        );
    }

    public List<Event> mapToEventList(final List<EventDto> eventDtoList) {
        return eventDtoList.stream().map(this::mapToEvent).collect(Collectors.toList());
    }

    public List<EventDto> mapToEventDtoList(final List<Event> eventList) {
        return eventList.stream().map(this::mapToEventDto).collect(Collectors.toList());
    }
}
