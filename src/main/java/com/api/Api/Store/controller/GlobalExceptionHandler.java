package com.api.Api.Store.controller;

import com.api.Api.Store.exception.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(ApiNotFoundException apiNotFoundExceptioni){
        return new ResponseEntity<String>(apiNotFoundExceptioni.getMessage(),HttpStatus.NOT_FOUND);
    }

}
