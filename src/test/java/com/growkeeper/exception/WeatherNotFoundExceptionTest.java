package com.growkeeper.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherNotFoundExceptionTest {

    @Test
    public void constructorTest() {
        WeatherNotFoundException exception = new WeatherNotFoundException();
        assertEquals(WeatherNotFoundException.class, exception.getClass());
    }

    @Test
    public void responseStatusAnnotationTest() {
        ResponseStatus responseStatusAnnotation = WeatherNotFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.NOT_FOUND, responseStatusAnnotation.code());
    }
}
