package com.java.resful.webservices.restfulwebservicespractice.bean;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 import static com.java.resful.webservices.restfulwebservicespractice.bean.RoleInfoConstant.WRITE_ACCESS;
 import static com.java.resful.webservices.restfulwebservicespractice.bean.RoleInfoConstant.READ_ACCESS;;

@RestController
public class UserController {

	@Autowired
	UserDao userdao;
	
	@GetMapping("/hello-check")
	public User checkReturn() {
		return new User(1,"nagesh",new Date());
		
	}
	
	@PreAuthorize("hasPermission('customer','"+RoleInfoConstant.WRITE_ACCESS+ "')")
	@GetMapping("/users")
	public List<User> getUser() {
		return userdao.findAll();
		
	}
	@PreAuthorize("hasPermission('customer','"+RoleInfoConstant.READ_ACCESS+ "')")
	@GetMapping("/users/{id}")
	public User specificuser(@PathVariable int id) {
          User user=userdao.findOne(id);
          if(user==null) {
        	  throw new UserNotFoundException("not found");
          }
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity insertuser(@Valid @RequestBody User user) {
		 User saveduser=userdao.save(user);
		 //created
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 .buildAndExpand(saveduser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();	
	}
	
	
	@DeleteMapping("/users/{id}")
	public void specificuserdelete(@PathVariable int id) {
          User user=userdao.delete(id);
          if(user==null) {
        	  throw new UserNotFoundException("id"+id);
          }
	}
}
