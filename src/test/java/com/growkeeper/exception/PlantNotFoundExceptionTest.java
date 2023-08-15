package com.growkeeper.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantNotFoundExceptionTest {

    @Test
    public void constructorTest() {
        PlantNotFoundException exception = new PlantNotFoundException();
        assertEquals(PlantNotFoundException.class, exception.getClass());
    }

    @Test
    public void responseStatusAnnotationTest() {
        ResponseStatus responseStatusAnnotation = PlantNotFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.NOT_FOUND, responseStatusAnnotation.code());
    }
}
