package com.growkeeper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.growkeeper.clients.FreePlantClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreePlantService {
    private final FreePlantClient freePlantClient;
    public void getInfo(String name) throws JsonProcessingException {
        freePlantClient.getId(name);
    }
}