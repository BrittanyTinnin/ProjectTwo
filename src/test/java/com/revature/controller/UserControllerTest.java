package com.revature.controller;
//import com.revature.daoimpl.*;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

//import java.util.List;

import org.junit.Test;

import com.revature.cors.CorsFilter;
import com.revature.model.Comment;
import com.revature.model.Photo;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PhotoService;
import com.revature.service.PostService;
import com.revature.service.UserService;

//import com.revature.model.User;

public class UserControllerTest {
UserController us = new UserController();
CorsFilter cf = new CorsFilter();
Comment c = new Comment();
Photo pt = new Photo();
Post po = new Post();
User ur = new User();
PhotoService ps = new PhotoService();
PostService pe = new PostService();
UserService uc = new UserService();



	@Test
	public void testGetAll() {
		assertEquals(us.getAll().get(0),null);
			}

	@Test
	public void testInsert() {
		//assertEquals(us);
	}

	@Test
	public void testGetUs() {
		;
	}

	@Test
	public void testSetUs() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllPhoto() {
		assertTrue(ps.getAll().size()>=0);
	}

	@Test
	public void testGetById() {
		assertTrue(ps.getById(1) instanceof Photo);
	}

	@Test
	public void testUpdate() {
		//assertTrue(ps.update(ph) instanceof Photo);
	}

	@Test
	public void testCreate() {
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHd() {
		fail("Not yet implemented");
	}

	

}
