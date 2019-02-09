package com.java.resful.webservices.restfulwebservicespractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
//@EnableFeignClients("com.java.resful.webservices.restfulwebservicespractice")
public class RestfulWebServicesPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesPracticeApplication.class, args);
	}

}

