package com.java.resful.webservices.restfulwebservicespractice.security;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{
	
	//private final Log logger = LogFactory.getLog(WebSecurityConfigurerAdapter.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("nagesssssssssssssssssssss333333333333399999999");
		   http.authorizeRequests() 
	        .antMatchers("/**").permitAll();           
	}

	
}
