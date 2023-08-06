package com.growkeeper.controller.api;

import com.growkeeper.service.api.PlantNetService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
@RequestMapping("/plantnet/")
@RequiredArgsConstructor
public class PlantNetController {
    private final PlantNetService plantNetService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        plantNetService.getName(file);
    }
}
