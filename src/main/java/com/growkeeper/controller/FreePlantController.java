package com.growkeeper.controller;

import com.growkeeper.domain.Plant;
import com.growkeeper.dto.PlantDto;
import com.growkeeper.exception.PlantNotFoundException;
import com.growkeeper.mapper.FreePlantMapper;
import com.growkeeper.service.FreePlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/freeplant/")
@RequiredArgsConstructor
public class FreePlantController {
    private final FreePlantService freePlantService;
    private final FreePlantMapper freePlantMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable("id") String id) throws PlantNotFoundException {
        return ResponseEntity.ok(freePlantMapper.mapToPlant(freePlantService.getDetailsOfPlant(id)));
    }
}
