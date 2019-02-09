package com.java.resful.webservices.restfulwebservicespractice.bean;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HelloController {

	@GetMapping("/hello-check")
	public User checkReturn() {
		return new User(1,"nagesh",new Date());
		
	}
	
}
