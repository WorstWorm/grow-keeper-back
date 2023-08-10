package com.growkeeper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WeatherNotFoundException extends RuntimeException {
    public WeatherNotFoundException() {
        System.out.println("WeatherNotFoundException");
    }
}

