package com.csbd.CSBD100.v.exception.handler;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class Error {
    private Date time;
    private String message;
    private String detail;
    private HttpStatus code;

    public Error(Date time, String message, String detail, HttpStatus code) {
        this.time = time;
        this.message = message;
        this.detail = detail;
        this.code = code;
    }

    public int getCode() {
        return code.value();
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
