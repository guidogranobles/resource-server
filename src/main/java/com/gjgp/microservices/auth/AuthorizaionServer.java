package com.gjgp.microservices.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class AuthorizaionServer extends SpringBootServletInitializer{
	
	 public static void main(String[] args) {
	        SpringApplication.run(AuthorizaionServer.class, args);
	    }

}
