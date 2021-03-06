package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Photo;


@Transactional
@Repository
public class PhotoDao {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private SessionFactory sesFact;
	
	
	
	
	public PhotoDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public PhotoDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	public List<Photo> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Photo", Photo.class).list();
	}

	public void create(Photo photo) {
		sesFact.getCurrentSession().save(photo);
	}

	public void update(Photo photo) {
		sesFact.getCurrentSession().update(photo);
	}


	public Photo findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateInfo(Photo t) {
		// TODO Auto-generated method stub

	}

	public Photo selectById(int id) {
		return sesFact.getCurrentSession().get(Photo.class, id);
	}

	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}

}
