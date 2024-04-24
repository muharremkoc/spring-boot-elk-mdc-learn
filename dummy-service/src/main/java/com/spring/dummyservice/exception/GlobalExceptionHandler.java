package com.spring.dummyservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) throws IOException {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> errors = new LinkedHashMap();

        errors.put("errorline", ex.getMessage());
        Date date = new Date();
        return new ResponseEntity<>(
                new CustomErrorDetails(
                        date,
                        status.value(),
                        errors
                ), new HttpHeaders(),
                status
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleIllegalArgumentException(BadRequestException ex) throws IOException {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, Object> errors = new LinkedHashMap();

        errors.put("errorline", ex.getMessage());
        Date date = new Date();
        return new ResponseEntity<>(
                new CustomErrorDetails(
                        date,
                        status.value(),
                        errors
                ), new HttpHeaders(),
                status
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) throws IOException {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, Object> errors = new LinkedHashMap();

        errors.put("errorline", ex.getMessage());
        Date date = new Date();
        return new ResponseEntity<>(
                new CustomErrorDetails(
                        date,
                        status.value(),
                        errors
                ), new HttpHeaders(),
                status
        );
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handleConflictException(ConflictException ex) throws IOException {
        HttpStatus status = HttpStatus.CONFLICT;
        Map<String, Object> errors = new LinkedHashMap();

        errors.put("errorline", ex.getMessage());
        Date date = new Date();
        return new ResponseEntity<>(
                new CustomErrorDetails(
                        date,
                        status.value(),
                        errors
                ), new HttpHeaders(),
                status
        );
    }


}