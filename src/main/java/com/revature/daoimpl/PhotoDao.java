package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.dao.GenericDao;
import com.revature.model.Photo;


@Transactional
@Repository
public class PhotoDao implements GenericDao<Photo> {

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
	public PhotoDao(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}

	@Override
	public List<Photo> selectAll() {
		return sesFact.getCurrentSession().createQuery("from Photo", Photo.class).list();
	}

	@Override
	public void create(Photo photo) {
		sesFact.getCurrentSession().save(photo);
	}

	@Override
	public void update(Photo photo) {
		sesFact.getCurrentSession().update(photo);
	}


	@Override
	public Photo findBy(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInfo(Photo t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Photo selectById(int id) {
		return sesFact.getCurrentSession().get(Photo.class, id);
	}

	@Override
	public void delete(int id) {
		sesFact.getCurrentSession().delete(selectById(id));
	}

}
