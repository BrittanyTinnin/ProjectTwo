package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Post;

@Transactional
public class PostRepo {
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sessFact;
	
	
	public void insert(Post p) {
		sessFact.getCurrentSession().save(p);
	}
	
	public List<Post> selectAll(){
		return sessFact.getCurrentSession().createQuery("from Post", Post.class).list();
	}
	
	public Post selectById(int id) {
		Transaction t=sessFact.getCurrentSession().beginTransaction();
		Post p=sessFact.getCurrentSession().load(Post.class, id);
		t.commit();
		return p;		
	}
	
	@Autowired
	public PostRepo(SessionFactory sessFact) {
		super();
		this.sessFact = sessFact;
	}
	
	public void update(Post p) {
		sessFact.getCurrentSession().save(p);
	}
}
