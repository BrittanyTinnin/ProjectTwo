package com.revature.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityService {
	
		 
		    private AuthenticationManager authenticationManager;

		    private UserDetailsService userDetailsService;

		    //Provides the current logged in user
		    public String findLoggedInUsername() {
		        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		        if (userDetails instanceof UserDetails) {
		            return ((UserDetails)userDetails).getUsername();
		        }

		        return null;
		    }
	}


