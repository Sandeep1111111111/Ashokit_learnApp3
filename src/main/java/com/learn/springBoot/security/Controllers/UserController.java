package com.learn.springBoot.security.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springBoot.security.Models.User;
import com.learn.springBoot.security.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
	return this. userService.getAllUsers();
	
	}
	
	@GetMapping("/current-user")
	public String getCurrentUser(Principal principal) {
		return principal.getName();
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName")String userName) {
	return this.userService.getUser(userName);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		
		return this.userService.addUser(user);
	}

}
