package com.revature.controller;
//import com.revature.daoimpl.*;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.revature.daoimpl.UserDao;
//import com.revature.cors.CorsFilter;
import com.revature.model.Comment;
import com.revature.model.Photo;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PhotoService;
import com.revature.service.PostService;
import com.revature.service.UserService;

public class UserControllerTest {
UserController uc = new UserController();
Comment c = new Comment();
Photo pt = new Photo();
Post po = new Post();
User ur = new User();
PhotoService ps = new PhotoService();
PostService pe = new PostService();
UserService us = new UserService();



	@Test
	public void testGetAll() {
		System.out.println("test get all");
		us.setUd(new UserDao());
		uc.setUs(us);
		System.out.println(uc.getAll().size());
		assertTrue(false);
	}

	@Test
	public void testInsert() {
		us.setUd(new UserDao());
		uc.setUs(us);
		User check=new User(7, "tester@test.com", "tryguy", "gonnawork", "purebreed", "none", null,
				null, null, null);
		System.out.println(check);
		assertEquals(uc.insert(check), check);
	}

	
//	@Test
//	public void testGetAllPhoto() {
//		assertTrue(ps.getAll().size()>=0);
//	}
//
//	@Test
//	public void testGetById() {
//		assertTrue(ps.getById(1) instanceof Photo);
//	}

//	@Test
//	public void testUpdate() {
////		assertTrue(ps.update(ph) instanceof Photo);
//		fail();
//	}
//
//	@Test
//	public void testCreate() {
//		fail();
//	}
//
//	@Test
//	public void testDelete() {
//	fail();
//	}


	

}