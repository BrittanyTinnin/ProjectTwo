package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.UserDao;
import com.revature.model.User;

@Service
public class UserService {

	private UserDao ud;
	
	public List<User> getAll(){
		return ud.selectAll();
	}
	
	public User getById(int id) {
		return ud.selectById(id);
	}
	
	public void update(User u) {
		ud.update(u);
	}
	
	public void create(User u) {
		System.out.println("inside user service");
		ud.create(u);
	}
	
	public void delete(int id) {
		ud.delete(id);
	}

	public UserDao getUd() {
		return ud;
	}

	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}	
}
