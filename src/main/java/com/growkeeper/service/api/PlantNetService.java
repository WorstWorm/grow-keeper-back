package com.growkeeper.service.api;

import com.growkeeper.clients.PlantNetClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlantNetService {
    private final PlantNetClient plantNetClient;

//    public void getName() {
//        plantNetClient.getName();
//    }

    public void getName(MultipartFile file) {
        File retFile = new File("tempImage");
        try {
            retFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(retFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        plantNetClient.getName(retFile);
        retFile.delete();
    }
}
