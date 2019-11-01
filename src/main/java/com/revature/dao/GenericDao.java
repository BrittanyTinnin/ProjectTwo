package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface GenericDao<T> {

	List<T> selectAll();
	
	void create(T t);
		
	void update(T t);
	
	void updateInfo(T t);
	
	T findBy(String t);
	
	T selectById(int t);
	
	void delete(int t);
}
