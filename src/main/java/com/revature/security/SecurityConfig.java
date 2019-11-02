package com.revature.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {

	protected void configure(HttpSecurity httpSecurity) {
		try {
			//authorize and permit the HTTPRequests
			httpSecurity
				.authorizeRequests()
				.anyRequest()
				.permitAll();
			
			httpSecurity.csrf().disable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
