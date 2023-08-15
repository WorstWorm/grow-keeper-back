package com.growkeeper.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationNotFoundExceptionTest {

    @Test
    public void constructorTest() {
        LocationNotFoundException exception = new LocationNotFoundException();
        assertEquals(LocationNotFoundException.class, exception.getClass());
    }

    @Test
    public void responseStatusAnnotationTest() {
        ResponseStatus responseStatusAnnotation = LocationNotFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.NOT_FOUND, responseStatusAnnotation.code());
    }
}
