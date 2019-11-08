package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/auth")
public class AuthController {

	private UserService us;

	@PostMapping(value="/login.app")
	public @ResponseBody User login(@RequestBody User user) {
		System.out.println("inside login method in auth controller");
		
		return us.getByUsername(user.getUsername());
//			
//			System.out.println("inside for loop of login method in auth controller");
//			System.out.println(u);
//			if(u.getUsername() == user.getUsername()) {
//				System.out.println("inside if statement of login auth controller");
//				System.out.println(u);
//				System.out.println(u.getUsername());
//				return u;
//			} else {
//				return null;
		
		
	}

	public UserService getUs() {
		return us;
	}

	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	
}
