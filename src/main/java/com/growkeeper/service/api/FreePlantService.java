package com.growkeeper.service.api;

import com.growkeeper.clients.FreePlantClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreePlantService {
    private final FreePlantClient freePlantClient;
    public void getInfo(String name) {
        freePlantClient.getPlant(name);
    }
}