package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Post;

@Transactional
@Repository
public class PostDao {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	
	
	public PostDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public PostDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public List<Post> selectAll() {
		System.out.println("inside dao post selectAll");
		return sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
	}

	public void create(Post post) {
		sesFact.getCurrentSession().save(post);
	}

	public void update(Post post) {
		sesFact.getCurrentSession().update(post);
	}

	public void updateInfo(Post t) { //in case when want to add feat to edit post
		// TODO Auto-generated method stub
		
	}

	public Post findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Post selectById(int id) {
		return sesFact.getCurrentSession().get(Post.class, id);
	}
	
	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}


}
