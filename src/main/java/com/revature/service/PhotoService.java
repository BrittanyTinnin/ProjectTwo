package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.PhotoDao;
import com.revature.model.Photo;

@Service
public class PhotoService {

	private PhotoDao hd;
	
	public List<Photo> getAll(){
		return hd.selectAll();
	}
	
	public Photo getById(int id) {
		return hd.selectById(id);
	}
	
	public void update(Photo ph) {
		hd.update(ph);
	}
	
	public void create(Photo ph) {
		hd.create(ph);
	}
	
	public void delete(int id) {
		hd.delete(id);
	}

	public PhotoDao getHd() {
		return hd;
	}

	@Autowired
	public void setHd(PhotoDao hd) {
		this.hd = hd;
	}
}
