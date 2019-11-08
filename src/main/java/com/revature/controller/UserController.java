package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	
	private UserService us;

	/**
	 * Returns a list of all users currently registered in the database
	 * 
	 * @return the List of User objects from the database user table
	 */
	@GetMapping(value = "/getAll.app")
	public @ResponseBody List<User> getAll() {
		System.out.println("inside get all controller");
		return us.getAllUsers();
	}

	/**
	 * Adds a newly registered to the database, and sets them as the current user of the application
	 * @param u	The object representation of the registering user
	 * @return	The newly registered user
	 */
	@PostMapping(value = "/post.app")
	public @ResponseBody User insert(@RequestBody User u) {
		System.out.println(u);
		us.create(u);
		return u;
	}
	
	/**
	 * Takes in a currently registered user, compares given information with stored data,
	 * stores new information in database, and updates the information of the session user
	 * @param u	A currently persisted user with updated data from database
	 * @return	The current user, with newly updated information
	 */
	@PostMapping(value="/update.app")
	public @ResponseBody User update(@RequestBody User u) {
		System.out.println("inside user controller update method" + u);
		us.update(u);
		return u;
	}


	/**
	 * Takes in a unique identification number, compares with the database 
	 * and returns the corresponding user with the matching identification
	 * or null if such user doesn't exist
	 * @param id 	The unique id of the desired user
	 * @return	The user with the given id or null if no such user exists
	 */
	@PostMapping(value = "/{id}/getById.app")
	public @ResponseBody User getById(@PathVariable("id") int id) {
		System.out.println("inside getById");
		return us.getById(id);
	}


	/**
	 * Accesses the UserService object that will be called with incoming data
	 * @return The currently set UserService object
	 */
	public UserService getUs() {
		return us;
	}

	/**
	 * Takes the given UserService object and attaches it to the Controller
	 * @param us	The UserService to be assigned to this controller
	 */
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}

	/**
	 * Generates a new UserController object to be used
	 */
	public UserController() {
		System.out.println("user controller");
	}

}
