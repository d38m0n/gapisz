package com.csbd.CSBD100.v.exception;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends RuntimeException {
    private HttpStatus code;

    public ItemNotFoundException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    public HttpStatus  getCode() {
        return code;
    }

    public void setCode(HttpStatus  code) {
        this.code = code;
    }
}

