package com.wipro.danielgorski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DanielgorskiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DanielgorskiApplication.class, args);
    }

}

