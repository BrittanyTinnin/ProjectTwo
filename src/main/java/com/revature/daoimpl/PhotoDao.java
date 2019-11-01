package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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
	
	
	
	public SessionFactory getSesFact() {
		return sesFact;
	}

	public void setSesFact(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}

	@Override
	public List<Photo> getAll() {
//		Session ses = HibernateUtil.getSession();
//		String hql = "from Photo";
//		return ses.createQuery(hql).list();
		return null;
	}

	@Override
	public void create(Photo photo) {
//		Session ses = HibernateUtil.getSession();
//		Transaction t = ses.beginTransaction();
//		ses.persist(photo);
//		t.commit();

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
