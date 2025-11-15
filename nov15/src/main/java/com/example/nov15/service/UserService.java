package com.example.nov15.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nov15.repository.CourseRepository;
import com.example.nov15.repository.UserRepository;
import com.example.nov15.request.Course;
import com.example.nov15.request.Users;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CourseRepository courseRepository;
	public void insertUser(Users user) {
		userRepository.save(user);
	}
	
	public Users enrollUserInCourses(int userId, List<Integer> courseIds) {
	    Users user = userRepository.findById(userId).orElseThrow();

	    List<Course> courses = courseRepository.findAllById(courseIds);

	    user.setCourses(courses);

	    return userRepository.save(user);
	}
}
