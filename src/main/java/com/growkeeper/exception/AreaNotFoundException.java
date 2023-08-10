package com.growkeeper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AreaNotFoundException extends RuntimeException {
    public AreaNotFoundException() {
        System.out.println("AreaNotFoundException");
    }
}
