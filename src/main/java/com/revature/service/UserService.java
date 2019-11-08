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
	
	
	public List<User> getAllUsers(){
		return ud.selectAll();
	}
	
	public User getById(int id) {
		return ud.selectById(id);
	}
	
	public User getByUsername(String username) {
		System.out.println("inside getByUsername");
		return ud.findByUsername(username);
	}
	
	public void update(User u) {
		System.out.println("inside user service update method");
		ud.update(u);
	}
	
	public void create(User u) {
		System.out.println("inside user service");
		ud.create(u);
	}
	
	public void delete(int id) {
		ud.delete(id);
	}

	public UserDao getUd() {
		return ud;
	}

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
