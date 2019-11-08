package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daoimpl.UserDao;
import com.revature.model.User;

@Service
public class UserService {

	/**
	 * Associated UserDao object, allowing for access to the database
	 */
	private UserDao ud;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<User> findGuests(User searchedUser) {
	
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<User> cq = cb.createQuery(User.class);
	    Root<User> quest = cq.from(User.class);
	    List<Predicate> predicates = new ArrayList<Predicate>();
	
	    if (searchedUser.getUsername() != null) {
	        predicates.add(cb.equal(quest.get("username"), searchedUser.getUsername()));
	    }
	    
	    if (searchedUser.getGender() != null) {
	        predicates.add(cb.like(quest.get("gender"), "%" + searchedUser.getGender() + "%"));
	    }
	    // other predicates
	
	    cq.select(quest).where(predicates.toArray(new Predicate[] {}));
	    List<User> guests = em.createQuery(cq).getResultList();
	    return guests;
	}
	
	/**
	 * Returns a list of all users currently registered in the database
	 * 
	 * @return the List of User objects from the database user table
	 */
	public List<User> getAllUsers(){
		return ud.selectAll();
	}
	
	/**
	 * Takes in a unique identification number, compares with the database 
	 * and returns the corresponding user with the matching identification
	 * or null if such user doesn't exist
	 * @param id 	The unique id of the desired user
	 * @return	The user with the given id or null if no such user exists
	 */
	public User getById(int id) {
		return ud.selectById(id);
	}
	
	/**
	 * Takes in a username, compares with the database 
	 * and returns the corresponding user with the matching username
	 * or null if such user doesn't exist
	 * @param username 	The username to be searched for
	 * @return	The user with the given username or null if no such user exists
	 */
	public User getByUsername(String username) {
		System.out.println("inside getByUsername");
		return ud.findByUsername(username);
	}
	
	/**
	 * Takes in a currently registered user, compares given information with stored data,
	 * stores new information in database, and updates the information of the session user
	 * @param u	A currently persisted user with updated data from database
	 */
	public void update(User u) {
		System.out.println("inside user service update method");
		ud.update(u);
	}
	
	/**
	 * Adds a newly registered to the database, and sets them as the current user of the application
	 * @param u	The object representation of the registering user
	 * @return	The newly registered user
	 */
	public void create(User u) {
		System.out.println("inside user service");
		ud.create(u);
	}
	
	/**
	 * Takes in a unique identification number and removes the user with
	 * the matching identification number
	 * @param id	the identification of the user to be removed
	 */
	public void delete(int id) {
		ud.delete(id);
	}

	/**
	 * Grabs the Dao object that is attached to the service object
	 * @return the attached UserDao object
	 */
	public UserDao getUd() {
		return ud;
	}

	/**
	 * Takes the given UserDao object and attaches it to the Service object
	 * @param ud	The UserDao to be assigned to this service object
	 */
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}	
}

//@Service
//public class GuestService {
//
//@PersistenceContext
//private EntityManager em;
//
//public List<Guest> findGuests(Guest searchedGuest) {
//
//    CriteriaBuilder cb = em.getCriteriaBuilder();
//    CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);
//    Root<Guest> quest = cq.from(Guest.class);
//    List<Predicate> predicates = new ArrayList<Predicate>();
//
//    if (searchedGuest.getPropertyIdentifier != null) {
//        predicates.add(cb.equal(quest.get("propertyIdentifier"), searchedGuest.getPropertyIdentifier));
//    }
//    if (searchedGuest.getFirstName != null) {
//        predicates.add(cb.like(quest.get("firstName"), "%" + searchedGuest.getFirstName + "%"));
//    }
//    // other predicates
//
//    cq.select(quest).where(predicates.toArray(new Predicate[] {}));
//    List<Guest> guests = em.createQuery(cq).getResultList();
//    return guests;
//}
