package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.dao.GenericDao;
import com.revature.model.Post;

@Transactional
@Repository
public class PostDao implements GenericDao<Post> {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	@Autowired
	public PostDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	@Override
	public List<Post> getAll() {
		return sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
	}

	@Override
	public void create(Post post) {
		sesFact.getCurrentSession().save(post);
	}

	@Override
	public void update(Post post) {
		sesFact.getCurrentSession().update(post);
	}

	@Override
	public void updateInfo(Post t) { //in case when want to add feat to edit post
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Post selectById(int id) {
		return sesFact.getCurrentSession().get(Post.class, id);
	}
	
	@Override
	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}


}
