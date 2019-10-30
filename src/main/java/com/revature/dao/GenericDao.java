package com.revature.dao;

import java.util.List;

public interface GenericDao<T> {

	List<T> getAll();
	
	void create(T t);
		
	void update(T t);
	
	void updateInfo(T t);
	
	T findBy(String t);
	
	void delete(T t);
}
