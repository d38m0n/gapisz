package com.csbd.CSBD100.v.exception.handler;


import com.csbd.CSBD100.v.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class Except extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
        Error resp = new Error(new Date(), ex.getMessage(), req.getDescription(false),ex.getCode());
        return new ResponseEntity(resp, ex.getCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Error resp = new Error(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.CONFLICT);
        return new ResponseEntity(resp, HttpStatus.CONFLICT);
    }
}
