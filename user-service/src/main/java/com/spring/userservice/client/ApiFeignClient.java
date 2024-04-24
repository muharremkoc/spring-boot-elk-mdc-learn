package com.spring.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "dummy-service", url = "http://localhost:6656/api/v1/dummy")
public interface ApiFeignClient {


    @GetMapping("/with-user/{userId}")
    void getDummy(@PathVariable("userId") Integer userId);

}
