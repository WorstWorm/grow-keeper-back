package com.growkeeper.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UploadConfig {
    @Value("${upload.directory}")
    private String uploadDirectory;
}
