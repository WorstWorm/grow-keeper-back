package com.growkeeper.clients;

import java.io.File;
import java.io.IOException;

import com.growkeeper.config.PlantNetConfig;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class PlantNetClient {
    private final PlantNetConfig plantNetConfig;

//    public void getName(){
//        File file1 = new File(plantNetConfig.getImageSource());
//        HttpEntity entity = MultipartEntityBuilder.create()
//                .addPart("images", new FileBody(file1))
//                .build();
//        HttpPost request = new HttpPost(plantNetConfig.getPlantnetApiEndpoint() + "?api-key=" + plantNetConfig.getPlantnetApiKey());
//        request.setEntity(entity);
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpResponse response;
//        try {
//            response = client.execute(request);
//            String jsonString = EntityUtils.toString(response.getEntity());
//            jsonString = jsonString.substring(jsonString.indexOf("scientificNameWithoutAuthor")+30);
//            jsonString = jsonString.substring(0, jsonString.indexOf("\""));
//            System.out.println(jsonString);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void getName(File file){
        HttpEntity entity = MultipartEntityBuilder.create()
                .addPart("images", new FileBody(file))
                .build();
        HttpPost request = new HttpPost(plantNetConfig.getPlantnetApiEndpoint() + "?api-key=" + plantNetConfig.getPlantnetApiKey());
        request.setEntity(entity);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            response = client.execute(request);
            String jsonString = EntityUtils.toString(response.getEntity());
            jsonString = jsonString.substring(jsonString.indexOf("scientificNameWithoutAuthor")+30);
            jsonString = jsonString.substring(0, jsonString.indexOf("\""));
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}