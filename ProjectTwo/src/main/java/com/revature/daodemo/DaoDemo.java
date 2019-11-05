//package com.revature.daodemo;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import com.revature.daoimpl.PhotoDao;
//import com.revature.daoimpl.PostDao;
//import com.revature.daoimpl.UserDao;
//import com.revature.model.Photo;
//import com.revature.model.Post;
//import com.revature.model.User;
//
//public class DaoDemo {
//
//	public static void main(String[] args) {
//		UserDao ud = new UserDao();
//		PostDao pd = new PostDao();
//		PhotoDao ph = new PhotoDao();
//		Set<Post> pt = new HashSet<>();
//		List<Photo> ft = new ArrayList<>();
//		
//		
//
//		User u1 = new User("this is my email2", "myUsername", "myPassword", "my breed", 4, "female", new java.sql.Timestamp(new Date().getTime()), new java.sql.Timestamp(new Date().getTime()), pt, ft);
//
//		
//		
////		
////		Post p1 = new Post();
////		p1.setDate(new java.sql.Timestamp(new Date().getTime()));
////		p1.setContent("made this post to test pic relationship");
////		p1.setUser(u4);
////		pt.add(p1);
//		
////		Photo f1 = new Photo();
////		f1.setDate(new java.sql.Timestamp(new Date().getTime()));
////		f1.setUrl("this is url");
////		f1.setUser(ud.findBy("myHome"));
////		ft.add(f1);
//		
//		ud.create(u1);
////		pd.create(p1);
////		ph.create(f1);
//		
//		
//		
//		
////		System.out.println(ft);
//		System.out.println(ud.selectAll());
//		
//		
////		ud.resetPassword("myHome", "testPassword");
////		System.out.println(ud.findBy("myHome"));
//		
//	}
//
//}
