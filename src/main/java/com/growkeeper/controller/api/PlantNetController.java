package com.growkeeper.controller.api;

import com.growkeeper.service.api.PlantNetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/plantnet/")
@RequiredArgsConstructor
public class PlantNetController {
    private final PlantNetService plantNetService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("plantImage") MultipartFile plantImage)  {
        System.out.println("upload Image called");
        String plantName = plantNetService.getPlantName(plantImage);
        return ResponseEntity.ok(plantName);
    }
}
