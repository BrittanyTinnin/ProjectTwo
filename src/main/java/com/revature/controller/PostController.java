package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Photo;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;

@Controller
@RequestMapping(value = "/post")
@CrossOrigin(origins = "*")
public class PostController {

	private PostService post;
	private UserService user;

	@RequestMapping(value = "/postIn.app", method = RequestMethod.POST)
	public @ResponseBody Post insert(@RequestBody Post p) {
		Photo ph = new Photo();
//	        p.setPhoto(ph);
		System.out.println(p);
		User u = p.getUser();
		int id = u.getUser_id();
		System.out.println(id);
		System.out.println(u);
		u.getPost().add(p);
		System.out.println("succes");
		user.postMan(id);
		return p;
	}

//	    @GetMapping(value="getAll.app")
//	    public ResponseEntity<List<Post>> getAll(){
//	        return new ResponseEntity<List<Post>>(post.getAll(), HttpStatus.OK);
//	    }

	@RequestMapping(value = "/getAll.app", method = RequestMethod.POST)
	public @ResponseBody List<Post> getAll() {
//	        List<Post> userPosts = new ArrayList<Post>();
//	        List<Post> temp = post.getAll();
//	        for(int i=0;i<temp.size();i++) {
//	            if(temp.get(i).getUser().getUser_id()==id) {
//	                userPosts.add(temp.get(i));
//	            }
		return post.getAll();
	}

	public PostService getPost() {
		return post;
	}

	@Autowired
	public void setPost(PostService post) {
		this.post = post;
	}

	public UserService getUser() {
		return user;
	}

	@Autowired
	public void setUser(UserService user) {
		this.user = user;
	}

}
