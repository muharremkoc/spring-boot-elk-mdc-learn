package com.spring.userservice.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ApiFeignFactory implements ApiFeignClient {

    final ApiFeignClient apiFeignClient;

    public ApiFeignFactory(@Qualifier("com.spring.userservice.client.ApiFeignClient") ApiFeignClient apiFeignClient) {
        this.apiFeignClient = apiFeignClient;
    }

    @Override
    public void getDummy(Integer id) {
         apiFeignClient.getDummy(id);
    }

}