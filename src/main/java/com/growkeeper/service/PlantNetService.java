package com.growkeeper.service;

import com.growkeeper.clients.PlantNetClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantNetService {
    private final PlantNetClient plantNetClient;

    public void getName() {
        plantNetClient.getName();
    }
}
