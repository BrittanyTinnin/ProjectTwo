package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Like;
import com.revature.model.Post;

@Transactional
@Repository
public class LikeDao {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	
	
	public LikeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public LikeDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public List<Like> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Like", Like.class).list();
	}

	public void create(Like like) {
		sesFact.getCurrentSession().save(like);
	}

	public void update(Like like) {
		sesFact.getCurrentSession().update(like);
	}

	public void updateInfo(Like l) { //in case when want to add feat to edit post
		// TODO Auto-generated method stub
		
	}

	public Post findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Like selectById(int id) {
		return sesFact.getCurrentSession().get(Like.class, id);
	}
	
	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}


}
