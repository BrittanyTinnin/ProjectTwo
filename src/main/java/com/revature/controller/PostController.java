package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Photo;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;

@Controller
@RequestMapping(value = "/post")
@CrossOrigin(origins = "*")
public class PostController {

	private PostService ps;
	private UserService us;

	@RequestMapping(value = "/postIt.app", method = RequestMethod.POST)
	public @ResponseBody Post insert(@RequestBody Post p) {
		System.out.println(p);
		ps.create(p);
		return p;
	}

//	    @GetMapping(value="getAll.app")
//	    public ResponseEntity<List<Post>> getAll(){
//	        return new ResponseEntity<List<Post>>(post.getAll(), HttpStatus.OK);
//	    }

	@RequestMapping(value = "/getAll.app", method = RequestMethod.GET)
	public @ResponseBody List<Post> getAll() {
		System.out.println("inside post getAll");
//	        List<Post> userPosts = new ArrayList<Post>();
//	        List<Post> temp = post.getAll();
//	        for(int i=0;i<temp.size();i++) {
//	            if(temp.get(i).getUser().getUser_id()==id) {
//	                userPosts.add(temp.get(i));
//	            }
		return ps.getAll();
	}

	public PostService getPost() {
		return ps;
	}

	@Autowired
	public void setPost(PostService post) {
		this.ps = post;
	}

	public UserService getUser() {
		return us;
	}

	@Autowired
	public void setUser(UserService user) {
		this.us = user;
	}

}
