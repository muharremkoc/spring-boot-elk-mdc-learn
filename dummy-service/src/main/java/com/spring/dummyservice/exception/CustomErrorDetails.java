package com.spring.dummyservice.exception;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@SuperBuilder
public class CustomErrorDetails {

    private Date timestamp;
    private int status;
    private Object errors;

    @Builder
    public CustomErrorDetails(Date timestamp, int status, Object errors) {
        this.timestamp = timestamp;

        this.status = status;
        this.errors = errors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }
}