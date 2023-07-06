package com.pyramidbuildersemployment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HiringCompanyNullException.class)
    public ResponseEntity<String> handleHiringCompanyNotFoundException(HiringCompanyNullException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
// creates ambiguity if added
//    @ExceptionHandler(HiringCompanyNullException.class)
//    public ResponseEntity<String> handleHiringCompanyNullException(HiringCompanyNullException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//    }

    // Other exception handlers...
}
