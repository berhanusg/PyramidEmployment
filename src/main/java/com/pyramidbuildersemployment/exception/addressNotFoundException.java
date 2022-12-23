package com.pyramidbuildersemployment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class addressNotFoundException extends RuntimeException{

    private static final long serialVersionidUID = 1L;
    public addressNotFoundException(String message) {

        super(message);
    }
}
