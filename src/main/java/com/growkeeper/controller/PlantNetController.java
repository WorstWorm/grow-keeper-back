package com.growkeeper.controller;

import com.growkeeper.service.PlantNetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/plantnet/")
@RequiredArgsConstructor
public class PlantNetController {
    private final PlantNetService plantNetService;

    @GetMapping()
    public void getName() {
        plantNetService.getName();
    }
}
