package com.java.resful.webservices.restfulwebservicespractice.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer Id;
	
	@Size(min=2,message="name should be atleate 2")
	private String name;
	
	@Past
	private Date dob;
	
	public User() {}

	public User(Integer id, String name, Date dob) {
		super();
		Id = id;
		this.name = name;
		this.dob = dob;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
