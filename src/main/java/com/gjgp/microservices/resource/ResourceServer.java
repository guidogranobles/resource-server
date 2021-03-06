package com.gjgp.microservices.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ResourceServer extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServer.class, args);
    }

}