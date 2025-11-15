package com.example.nov15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nov15.request.Course;
import com.example.nov15.service.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody @Valid Course course) {
		service.insertCourse(course);
		
		return course;
	}
}
