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

    @GetMapping()
    public ResponseEntity<List<PlantDto>> getPlants() {
        return ResponseEntity.ok(plantMapper.mapToPlantDtoList(plantService.getPlants()));
    }

    @GetMapping("/{plant}")
    public ResponseEntity<PlantDto> getPlant(@PathVariable("plant") String plantScientificName) throws PlantNotFoundException {
        return ResponseEntity.ok(plantMapper.mapToPlantDto(plantService.getPlant(plantScientificName)));
    }


    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlant(@RequestBody PlantDto plantDto) {
        plantService.addPlant(plantMapper.mapToPlant(plantDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{plant}")
    public ResponseEntity<Void> deletePlant(@PathVariable("plant") String plantScientificName) throws PlantNotFoundException {
        plantService.deletePlant(plantScientificName);
        return ResponseEntity.ok().build();
    }
}
