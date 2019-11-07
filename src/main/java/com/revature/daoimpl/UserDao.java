package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;


@Transactional
@Repository
public class UserDao {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	
	
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public List<User> selectAll() {
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}

	public void create(User user) {
		sesFact.getCurrentSession().save(user);
	}

	public void update(User user) {
		System.out.println("in user dao update method");
		sesFact.getCurrentSession().update(user);
	}
	
	public void updateInfo(User t) {
		// TODO Auto-generated method stub
		
	}


	public User findBy(String username) {
		return sesFact.getCurrentSession().get(User.class, username);
//		Session ses = HibernateUtil.getSession();
//		String hql = "from User u where u.username = :username";
//		Query q = ses.createQuery(hql);
//		q.setParameter("username", username);
//		return  (User) q.getSingleResult();
	}
	

	
	public void resetPassword(String username, String password) {
//		Session ses = HibernateUtil.getSession();
//		Transaction t = ses.beginTransaction();
//		String hql = "update User set password = :password where username = :username";
//		Query q = ses.createQuery(hql);
//		q.setParameter("password", password);
//		q.setParameter("username", username);
//		q.executeUpdate();
//		t.commit();
	}
	
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	

	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}
}
