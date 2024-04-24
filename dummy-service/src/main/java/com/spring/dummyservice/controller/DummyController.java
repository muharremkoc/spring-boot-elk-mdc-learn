package com.spring.dummyservice.controller;

import com.spring.dummyservice.domain.Dummy;
import com.spring.dummyservice.service.DummyService;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dummy")
public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("/with-user/{userId}")
    public void getDummy(@PathVariable("userId")int userId){
        MDC.put("GET_DUMMY_REQUEST_ID", UUID.randomUUID().toString());
        MDC.put("USER_ID", String.valueOf(userId));
        dummyService.getDummy(userId);
    }
}
