package com.csbd.CSBD100.v.exception;

import org.springframework.http.HttpStatus;

public class ClientException extends RuntimeException {
    private HttpStatus code;

    public ClientException(String message, HttpStatus code) {
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

