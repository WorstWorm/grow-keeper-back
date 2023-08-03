package com.growkeeper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.growkeeper.service.FreePlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/freeplant/")
@RequiredArgsConstructor
public class FreePlantController {
    private final FreePlantService freePlantService;

    @GetMapping("/{plant}")
    public void getName(@PathVariable("plant") String plant) throws JsonProcessingException {
        freePlantService.getInfo(plant);
    }
}


