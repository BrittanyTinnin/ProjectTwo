package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.services.PostService;

public class PostController {
	private PostService ps;

	public PostService getUs() {
		return ps;
	}

	@Autowired
	public void setUs(PostService ps) {
		this.ps = ps;
	}
	
}
