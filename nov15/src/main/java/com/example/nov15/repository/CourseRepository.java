package com.example.nov15.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nov15.request.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

}
