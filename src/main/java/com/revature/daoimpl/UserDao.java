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

	/**
	 * A SessionFactory object, to generate sessions and return/invalidate the
	 * current session
	 */
	private SessionFactory sesFact;

	/**
	 * Generates the Dao object to connect to the user table in the database
	 */
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Generates the Dao object to connect to the user table in the database with a
	 * specified SessionFactory object
	 * 
	 * @param sesFact A sessionFactory object to be assigned to the Dao
	 */
	@Autowired
	public UserDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	/**
	 * Returns a list of all users currently registered in the database
	 * 
	 * @return the List of User objects from the database user table
	 */
	public List<User> selectAll() {
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}

	/**
	 * Adds a newly registered to the database, and sets them as the current user of
	 * the application
	 * 
	 * @param u The object representation of the registering user
	 */
	public void create(User user) {
		sesFact.getCurrentSession().save(user);
	}

	/**
	 * Takes in a currently registered user, compares given information with stored
	 * data, stores new information in database, and updates the information of the
	 * session user
	 * 
	 * @param u A currently persisted user with updated data from database
	 */
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public void updateInfo(User t) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Takes in a username, compares with the database and returns the corresponding
	 * user with the matching username or null if such user doesn't exist
	 * 
	 * @param username The username to be searched for
	 * @return The user with the given username or null if no such user exists
	 */
	public User findByUsername(String username) {
		System.out.println("inside findyByUsername in dao");
//		return sesFact.getCurrentSession().get(User.class, username);
		String hql = "from User u where u.username = :username";
		return (User) sesFact.getCurrentSession().createQuery(hql).setParameter("username", username).getSingleResult();
//		Session ses = HibernateUtil.getSession();
//		String hql = "from User u where u.username = :username";
//		Query q = ses.createQuery(hql);
//		q.setParameter("username", username);
//		return  (User) q.getSingleResult();
	}
	

	/**
	 * @deprecated
	 */
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

	


	/**
	 * Takes in a unique identification number, compares with the database and
	 * returns the corresponding user with the matching identification or null if
	 * such user doesn't exist
	 * 
	 * @param id The unique id of the desired user
	 * @return The user with the given id or null if no such user exists
	 */

	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	

	/**
	 * Takes in a unique identification number and removes the user with
	 * the matching identification number
	 * @param id	the identification of the user to be removed
	 */
	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}
}
