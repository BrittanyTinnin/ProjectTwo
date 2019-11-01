package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	
	private UserService us;
	
	@GetMapping(value="/getAll.app")
	public @ResponseBody List<User> getAll(){
		System.out.println("inside get all controller");
		return us.getAll();
	}

	public UserService getUs() {
		return us;
	}

	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	public UserController() {
		System.out.println("user controller");
	}

}
