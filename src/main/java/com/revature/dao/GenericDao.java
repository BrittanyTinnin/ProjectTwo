package com.revature.dao;

import java.util.List;

public interface GenericDao<T> {

	List<T> getAll();
	
	void create(T t);
		
	void update(T t, String[] params);
	
	void findBy(T t);
	
	void delete(T t);
}
