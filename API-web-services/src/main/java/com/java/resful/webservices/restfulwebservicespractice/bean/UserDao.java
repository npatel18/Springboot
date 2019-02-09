package com.java.resful.webservices.restfulwebservicespractice.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	static List<User> userlist= new ArrayList<>();
	
	private static int userCount=3;
		
	static {
		userlist.add(new User (1,"nagesh",new Date()));
		userlist.add(new User (2,"amit",new Date()));
		userlist.add(new User (3,"priyanka",new Date()));
	}
	
	public List<User> findAll(){
		return userlist;
		
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		
		userlist.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		
		for(User u:userlist){
			if(u.getId()==id) {
			return u;	
			}
		}
		return null;
	}
	
	
	public User delete(int id) {
		Iterator<User>  useritrator= userlist.iterator();	
		while(useritrator.hasNext()) {
			User user=useritrator.next();
			if(useritrator.next().getId()==id) {
				useritrator.remove();
				return user;
			}
		}
		return null;
	}

}
