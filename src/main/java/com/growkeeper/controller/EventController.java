package com.growkeeper.controller;

import com.growkeeper.dto.EventDto;
import com.growkeeper.mapper.EventMapper;
import com.growkeeper.service.ActionService;
import com.growkeeper.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ActionService actionService;
    @GetMapping()
    public ResponseEntity<List<EventDto>> getEvents() {
        return ResponseEntity.ok(eventMapper.mapToEventDtoList(eventService.getEvents()));
    }

    @PutMapping(path="/{id}")
    public void switchCompleted(@PathVariable("id") int id) {
        eventService.updateEvent(id);
    }

    @GetMapping(path="/{id}")
    public void callActionCheck() {
        actionService.neededActionCheck();
    }
}
