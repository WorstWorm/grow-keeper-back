package com.growkeeper.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaNotFoundExceptionTest {

    @Test
    public void constructorTest() {
        AreaNotFoundException exception = new AreaNotFoundException();
        assertEquals(AreaNotFoundException.class, exception.getClass());
    }

    @Test
    public void responseStatusAnnotationTest() {
        ResponseStatus responseStatusAnnotation = AreaNotFoundException.class.getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.NOT_FOUND, responseStatusAnnotation.code());
    }
}
