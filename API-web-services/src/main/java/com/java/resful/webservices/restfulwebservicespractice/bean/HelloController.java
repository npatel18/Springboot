package com.java.resful.webservices.restfulwebservicespractice.bean;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HelloController {

	@GetMapping("/hellotest/{userid}/{FTName}")
	public String checkReturn(@PathVariable String userid,@PathVariable String FTName) {
		//return new User(1,"nagesh",new Date());
		System.out.println("userid" +userid+"roleid"+FTName);
		return "Success response enjoy";
		
	}
	
}
