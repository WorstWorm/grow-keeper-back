package com.growkeeper.controller;

import com.growkeeper.dto.PlantDto;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.mapper.PlantMapper;
import com.growkeeper.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;
    private final PlantMapper plantMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PlantDto> getPlant(@PathVariable("id") String plantScientificName) throws PlantNotFoundException {
        return ResponseEntity.ok(plantMapper.mapToPlantDto(plantService.getPlant(plantScientificName)));
    }

    @GetMapping()
    public ResponseEntity<List<PlantDto>> getPlants() {
        return ResponseEntity.ok(plantMapper.mapToPlantDtoList(plantService.getPlants()));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlant(@RequestBody PlantDto plantDto) {
        plantService.createPlant(plantMapper.mapToPlant(plantDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantDto> updatePlant(@PathVariable("id") String plantScientificName, @RequestBody PlantDto plantDto) {
        plantService.updatePlant(plantScientificName, plantMapper.mapToPlant(plantDto));
        return ResponseEntity.ok(plantMapper.mapToPlantDto(plantService.getPlant(plantDto.getPlantScientificName())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable("id") String plantScientificName) throws PlantNotFoundException {
        plantService.deletePlant(plantScientificName);
        return ResponseEntity.ok().build();
    }
}
