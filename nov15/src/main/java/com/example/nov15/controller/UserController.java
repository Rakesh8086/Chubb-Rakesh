package com.example.nov15.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nov15.request.Users;
import com.example.nov15.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public Users saveUser(@RequestBody @Valid Users user) {
		service.insertUser(user);
		
		return user;
	}
	
	@PostMapping("/users/{userId}/enroll")
	public Users enrollUser(@PathVariable int userId, 
			@RequestBody List<Integer> courseIds) {
	    
		return service.enrollUserInCourses(userId, courseIds);
	}
}
