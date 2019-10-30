package com.revature.daoimpl;

import java.util.List;

import javax.persistence.Query;

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
		Transaction t = ses.beginTransaction();
		ses.persist(user);
		t.commit();
	}

	@Override
	public void update(User user) {
		
	}


	@Override
	public User findBy(String username) {
		Session ses = HibernateUtil.getSession();
		String hql = "from User u where u.username = :username";
		Query q = ses.createQuery(hql);
		q.setParameter("username", username);
		return  (User) q.getSingleResult();
	}
	

	
	public void resetPassword(String username, String password) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		String hql = "update User set password = :password where username = :username";
		Query q = ses.createQuery(hql);
		q.setParameter("password", password);
		q.setParameter("username", username);
		q.executeUpdate();
		t.commit();
	}
	

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	
}
