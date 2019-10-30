package com.revature.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.GenericDao;
import com.revature.model.Photo;
import com.revature.util.HibernateUtil;

public class PhotoDao implements GenericDao<Photo> {

	@Override
	public List<Photo> getAll() {
		Session ses = HibernateUtil.getSession();
		String hql = "from Photo";
		return ses.createQuery(hql).list();
	}

	@Override
	public void create(Photo photo) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		ses.persist(photo);
		t.commit();
		
	}

	@Override
	public void update(Photo t) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void findBy(Photo t) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void delete(Photo t) {
		// TODO Auto-generated method stub
		
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



}
