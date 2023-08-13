package com.growkeeper.service;

import com.growkeeper.domain.Event;
import com.growkeeper.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void updateEvent(int id) {
        Event event = eventRepository.findById(id).get();
        event.switchCompleted();
        eventRepository.save(event);
    }

    public void addEvents(List<Event> newEvents) {
        eventRepository.deleteAll();
        eventRepository.saveAll(newEvents);
    }

}