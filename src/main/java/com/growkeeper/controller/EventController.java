package com.growkeeper.controller;

import com.growkeeper.dto.EventDto;
import com.growkeeper.mapper.EventMapper;
import com.growkeeper.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping()
    public ResponseEntity<List<EventDto>> getEvents() {
        return ResponseEntity.ok(eventMapper.mapToEventDtoList(eventService.getEvents()));
    }

    @PutMapping(path="/{eventId}")
    public void switchCompleted(@PathVariable("eventId") int eventId) {
        eventService.updateEvent(eventId);
    }

}
