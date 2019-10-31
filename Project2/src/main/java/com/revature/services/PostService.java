package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Post;
import com.revature.repo.PostRepo;
public class PostService {

	private PostRepo pr;
	
	public List<Post> getAllPosts(){
		return pr.selectAll();
	}
	
	public Post getById(int id) {
		return pr.selectById(id);
	}
	
	public void update(Post p) {
		pr.update(p);
	}
	
	public void insert(Post p) {
		pr.update(p);
	}

	@Autowired
	public void setUr(PostRepo pr) {
		this.pr = pr;
	}
	
}
