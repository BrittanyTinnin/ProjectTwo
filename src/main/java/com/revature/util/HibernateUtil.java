package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session sess;
    private static SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    
    public static Session getSession() {
    	System.out.println("line 17 of getSession()");
        if(sess==null) {
            sess=sf.openSession();
            System.out.println("line 19 of getSession()");
        }
        return sess;
    }
    
	
	public static void closeSess() {
		sess.close();
	}
}
