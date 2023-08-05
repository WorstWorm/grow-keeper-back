package com.growkeeper.controller;

import com.growkeeper.dto.LocationDto;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.mapper.LocationMapper;
import com.growkeeper.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable("id") String city) throws LocationNotFoundException {
        return ResponseEntity.ok(locationMapper.mapToLocationDto(locationService.getLocation(city)));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createLocation(@RequestBody LocationDto locationDto) {
        locationService.createLocation(locationMapper.mapToLocation(locationDto));
        return ResponseEntity.ok().build();
    }
}
