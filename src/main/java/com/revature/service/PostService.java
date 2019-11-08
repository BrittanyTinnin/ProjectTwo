package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.PostDao;
import com.revature.model.Post;

@Service
public class PostService {

	private PostDao pd;
	
	public List<Post> getAll(){
		System.out.println("inside getAll service");
		return pd.selectAll();
	}
	
	public Post getById(int id) {
		return pd.selectById(id);
	}
	
	public void update(Post p) {
		pd.update(p);
	}
	
	public void create(Post p) {
		pd.create(p);
	}
	
	public void delete(int id) {
		pd.delete(id);
	}

	public PostDao getPd() {
		return pd;
	}

	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}
}
