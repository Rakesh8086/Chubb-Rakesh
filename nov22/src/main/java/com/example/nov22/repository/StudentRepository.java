package com.example.nov22.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.nov22.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {
	
}
