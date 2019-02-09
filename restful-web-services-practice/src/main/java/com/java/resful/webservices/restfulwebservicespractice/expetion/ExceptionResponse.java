package com.java.resful.webservices.restfulwebservicespractice.expetion;

import java.util.Date;



public class ExceptionResponse {
	
	private Date timestame;
	private String msg;
	private String details;
	
	public ExceptionResponse(Date timestame, String msg, String details) {
		super();
		this.timestame = timestame;
		this.msg = msg;
		this.details = details;
	}
	public Date getTimestame() {
		return timestame;
	}
	public void setTimestame(Date timestame) {
		this.timestame = timestame;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}


}
