package com.revature.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.GenericDao;
import com.revature.model.Post;
import com.revature.util.HibernateUtil;

public class PostDao implements GenericDao<Post> {

	@Override
	public List<Post> getAll() {
		Session ses = HibernateUtil.getSession();
		String hql = "from Post";
		return ses.createQuery(hql).list();
	}

	@Override
	public void create(Post post) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		ses.persist(post);
		t.commit();
	}

	@Override
	public void update(Post t) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void findBy(Post t) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void delete(Post t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInfo(Post t) {
		// TODO Auto-generated method stub
		
	}

}
