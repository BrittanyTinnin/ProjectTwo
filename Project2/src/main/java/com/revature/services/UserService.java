package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.repo.UserRepo;

public class UserService {

	private UserRepo ur;
	
	public List<User> getAllUsers(){
		return ur.selectAll();
	}
	
	public User getById(int id) {
		return ur.selectById(id);
	}
	
	public void update(User u) {
		ur.update(u);
	}
	
	public void insert(User u) {
		ur.update(u);
	}

	@Autowired
	public void setUr(UserRepo ur) {
		this.ur = ur;
	}
	
}
