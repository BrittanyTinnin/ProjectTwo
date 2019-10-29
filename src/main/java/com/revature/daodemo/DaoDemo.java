package com.revature.daodemo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.revature.daoimpl.UserDao;
import com.revature.model.Post;
import com.revature.model.User;

public class DaoDemo {

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		Post p1 = new Post();
		Set<Post> pt = new HashSet<>();
		
		
		User u1 = new User("this is my email", "myUsername", "myPassword", "my breed", 4, "female", new java.sql.Timestamp(new Date().getTime()), new java.sql.Timestamp(new Date().getTime()));
//		User u1 = new User();
		
		ud.create(u1);
	}

}
