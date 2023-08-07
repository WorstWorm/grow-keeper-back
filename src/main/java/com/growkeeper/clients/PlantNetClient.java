package com.growkeeper.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.growkeeper.config.PlantNetConfig;
import com.growkeeper.dto.api.plantNetDto.PlantNetRootDto;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PlantNetClient {
    private final PlantNetConfig plantNetConfig;

    public void getName(File file){
        HttpEntity entity = MultipartEntityBuilder.create().addPart("images", new FileBody(file)).build();
        HttpPost request = new HttpPost(plantNetConfig.getPlantnetApiEndpoint()
                + "?api-key=" + plantNetConfig.getPlantnetApiKey());
        request.setEntity(entity);
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(request);
            String jsonString = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            PlantNetRootDto plantNetRootDto = objectMapper.readValue(jsonString, PlantNetRootDto.class);

            //operations on plant name here...
            System.out.println(plantNetRootDto.getResults().get(0).getSpecies().getScientificNameWithoutAuthor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}