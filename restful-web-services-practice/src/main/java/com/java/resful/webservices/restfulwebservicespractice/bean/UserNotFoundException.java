package com.java.resful.webservices.restfulwebservicespractice.bean;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND	)
public class UserNotFoundException extends RuntimeException {

	private String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	
	
}
