package com.java.resful.webservices.restfulwebservicespractice.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.web.client.RestTemplate;

import com.java.resful.webservices.restfulwebservicespractice.bean.RoleInfoConstant;


public class CustomPermissionEvaluator implements PermissionEvaluator {
    
	//@Autowired
	//private FeignclientProxy feignclientproxy;
	
	@Override
    public boolean hasPermission(
      Authentication auth, Object targetDomainObject, Object permission) {
		System.out.println("@@@@@@@@@@@@@@2"+auth+"!!!!!"+targetDomainObject+"%%%%"+permission);
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)){
            return false;
        }
        //String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
         
        return hasPrivilege(auth, targetDomainObject.toString(), permission.toString());
    }
 
    @Override
    public boolean hasPermission(
      Authentication auth, Serializable targetId, String targetType, Object permission) {
    	System.out.println("Haspermission"+auth+"&&&&&&"+targetId+"targetType"+targetType+"***********"+permission);
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(), 
          permission.toString().toUpperCase());
    }

    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
    	System.out.println("Entring in hasprivilege");
    	
    	Map<String, String> urlVariable= new HashMap<String,String>();
    	urlVariable.put("userid", "NAGESH");
    	urlVariable.put("FTName", "R12345");
    	
    	ResponseEntity<String> result=new RestTemplate().getForEntity("http://localhost:8079/check/hellotest/{userid}/{FTName}", String.class,urlVariable);
    	String r =result.getBody();
    	System.out.println("before calling the feign client");
    	//String r =feignclientproxy.checkReturn("nagesh","R123");
    	//System.out.println("result recieved from diffrent services%%%%%%%"+r);
    	
    	if(permission.equals(RoleInfoConstant.WRITE_ACCESS) && targetType.equals("customer")) {
    		return true;
    	}
    	else {
    		return false;	
    	}
    }
}
