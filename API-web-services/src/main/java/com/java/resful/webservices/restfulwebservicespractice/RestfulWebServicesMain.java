package com.java.resful.webservices.restfulwebservicespractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class RestfulWebServicesMain {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesMain.class, args);
	}

}

