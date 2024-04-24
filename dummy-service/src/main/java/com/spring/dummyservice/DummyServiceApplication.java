package com.spring.dummyservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DummyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyServiceApplication.class, args);
		log.info("Dummy Service Started");
	}

}
