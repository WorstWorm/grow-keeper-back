package com.growkeeper.controller.api;

import com.growkeeper.service.api.FreePlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/freeplant/")
@RequiredArgsConstructor
public class FreePlantController {
    private final FreePlantService freePlantService;

    @GetMapping("/{plant}")
    public void getInfo(@PathVariable("plant") String plant) {
        freePlantService.getInfo(plant);
    }
}


