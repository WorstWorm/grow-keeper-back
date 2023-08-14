package com.growkeeper.controller;

import com.growkeeper.dto.PlantDto;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.mapper.PlantMapper;
import com.growkeeper.service.PlantService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{plantName}")
    public ResponseEntity<PlantDto> getPlant(@PathVariable("plantName") String plantScientificName) throws PlantNotFoundException {
        return ResponseEntity.ok(plantMapper.mapToPlantDto(plantService.getPlant(plantScientificName)));
    }
}
