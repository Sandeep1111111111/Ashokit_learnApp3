 package com.learn.springBoot.security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.springBoot.security.Models.User;

@Service
public class UserService {
	
	List<User> list = new ArrayList<>();
	
	public UserService() {
		list.add(new User("Sandeep","abc","sandeep@gmail.com"));
		list.add(new User("Siddhant","siddh","siddhant@gmail.com"));
		
	}
	
	public List<User> getAllUsers(){
		return this.list;
	}

	
	public User getUser(String userName) {
		return this.list.stream().filter((user)->user.getUserName().equals(userName)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		
		this.list.add(user);
		return user;
	}
}
