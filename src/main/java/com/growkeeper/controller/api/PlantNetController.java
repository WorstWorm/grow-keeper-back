package com.growkeeper.controller.api;

import com.growkeeper.service.api.PlantNetService;
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
