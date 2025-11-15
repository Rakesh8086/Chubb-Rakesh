package com.example.nov15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nov15.repository.CourseRepository;
import com.example.nov15.request.Course;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	public void insertCourse(Course course) {
		courseRepository.save(course);
	}
}
