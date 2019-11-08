package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.LikeDao;
import com.revature.model.Like;

@Service
public class LikeService {
	private LikeDao ld;
	
	public List<Like> getAll(){
		return ld.selectAll();
	}
	
	public Like getById(int id) {
		return ld.selectById(id);
	}
	
	public void update(Like l) {
		ld.update(l);
	}
	
	public void create(Like l) {
		ld.create(l);
	}
	
	public void delete(int id) {
		ld.delete(id);
	}

	public LikeDao getLd() {
		return ld;
	}

	@Autowired
	public void setHd(LikeDao ld) {
		this.ld = ld;
	}
}
