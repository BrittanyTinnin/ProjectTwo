package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.dao.GenericDao;
import com.revature.model.User;


@Transactional
@Repository
public class UserDao implements GenericDao<User> {
	
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
	public UserDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	@Override
	public List<User> getAll() {
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}

	@Override
	public void create(User user) {
		sesFact.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}


	@Override
	public User findBy(String username) {
		return sesFact.getCurrentSession().load(User.class, username);
//		Session ses = HibernateUtil.getSession();
//		String hql = "from User u where u.username = :username";
//		Query q = ses.createQuery(hql);
//		q.setParameter("username", username);
//		return  (User) q.getSingleResult();
	}
	

	
//	public void resetPassword(String username, String password) {
//		Session ses = HibernateUtil.getSession();
//		Transaction t = ses.beginTransaction();
//		String hql = "update User set password = :password where username = :username";
//		Query q = ses.createQuery(hql);
//		q.setParameter("password", password);
//		q.setParameter("username", username);
//		q.executeUpdate();
//		t.commit();
//	}
	

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	
}
