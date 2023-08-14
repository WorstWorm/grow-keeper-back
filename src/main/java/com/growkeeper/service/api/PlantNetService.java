package com.growkeeper.service.api;

import com.growkeeper.clients.PlantNetClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlantNetService {
    @Autowired
    private final PlantNetClient plantNetClient;

//    public String getPlantName(MultipartFile plantImage) {
//        File temporaryImage = new File("temporaryImage");
//        try {
//            temporaryImage.createNewFile();
//            FileOutputStream fos = new FileOutputStream(temporaryImage);
//            fos.write(plantImage.getBytes());
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String plantName = plantNetClient.getPlantScientificName(temporaryImage);
//        temporaryImage.delete();
//        return plantName;
//    }

    private File prepareFile(MultipartFile plantImage) {
        File temporaryFile = new File("temporaryFile");
        try {
            temporaryFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(temporaryFile);
            fos.write(plantImage.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create temporary image", e);
        }
        return temporaryFile;
    }

    public String getPlantName(MultipartFile plantImage) {
        File temporaryFile = prepareFile(plantImage);
        String plantName = plantNetClient.getPlantScientificName(temporaryFile);
        deleteTemporaryFile(temporaryFile);
        return plantName;
    }

    private void deleteTemporaryFile(File temporaryFile) {
        if(!temporaryFile.delete()) {
            throw new RuntimeException("Failed to delete temporary file");
        }
    }
}
