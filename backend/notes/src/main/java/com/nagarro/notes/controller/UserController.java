package com.nagarro.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.notes.model.User;
import com.nagarro.notes.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public User registerUserAccount(@RequestBody User newUser) throws Exception{
		System.out.println(newUser);
		
		try {
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			return userService.addUser(newUser);
		}
		catch (Exception e) {
			throw new Exception("User with email " + newUser.getEmail() + " already exists!!");
		}
	}
	
}
