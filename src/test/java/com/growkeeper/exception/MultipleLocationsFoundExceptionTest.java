package com.growkeeper.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleLocationsFoundExceptionTest {

    @Test
    public void constructorTest() {
        MultipleLocationsFoundException exception = new MultipleLocationsFoundException();
        assertEquals(MultipleLocationsFoundException.class, exception.getClass());
    }

    @Test
    public void responseStatusAnnotationTest() {
        ResponseStatus responseStatusAnnotation = MultipleLocationsFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseStatusAnnotation.code());
    }
}
