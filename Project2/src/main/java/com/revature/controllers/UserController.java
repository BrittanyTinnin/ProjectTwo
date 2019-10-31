package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.services.UserService;

@Controller
public class UserController {

	private UserService us;

	public UserService getUs() {
		return us;
	}

	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
}
