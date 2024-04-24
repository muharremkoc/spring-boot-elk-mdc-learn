package com.spring.dummyservice.model;

public class ErrorResponse extends Response{

    public ErrorResponse(String message) {
        super(false, message);
    }
}