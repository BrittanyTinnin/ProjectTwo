package com.revature.repo;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Transactional
@Repository
public class UserRepo {
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sessFact;
	
	@Transactional
	public void insert(User u) {
		sessFact.getCurrentSession().save(u);
	}
	
	public List<User> selectAll(){
		Session ses=sessFact.getCurrentSession();
		return ses.createQuery("from User", User.class).list();
	}
	
	public User selectById(int id) {
		Session ses=sessFact.getCurrentSession();
		Transaction t=ses.beginTransaction();
		User u=ses.load(User.class, id);
		t.commit();
		return u;		
	}
	
	@Autowired
	public UserRepo(SessionFactory sessFact) {
		super();
		this.sessFact = sessFact;
	}
	
	public void update(User u) {
		sessFact.getCurrentSession().save(u);
	}
}
