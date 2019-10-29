package com.revature.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.GenericDao;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao implements GenericDao<User> {

	@Override
	public List<User> getAll() {
		Session ses = HibernateUtil.getSession();
		String hql = "from User";
		return ses.createQuery(hql).list();
	}

	@Override
	public void create(User user) {
		Session ses = HibernateUtil.getSession();
		System.out.println("line 24 of create");
		Transaction t = ses.beginTransaction();
		ses.persist(user);
		t.commit();
	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findBy(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}



	
}
