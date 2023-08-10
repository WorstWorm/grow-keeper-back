package com.growkeeper.controller.api;

import com.growkeeper.service.api.PlantNetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/plantnet/")
@RequiredArgsConstructor
public class PlantNetController {
    private final PlantNetService plantNetService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@RequestParam("file") MultipartFile file)  {
        plantNetService.getName(file);
    }
}
