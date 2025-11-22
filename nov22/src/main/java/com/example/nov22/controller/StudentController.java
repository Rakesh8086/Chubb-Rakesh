package com.example.nov22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nov22.model.Student;
import com.example.nov22.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	// mongodb://localhost:27017
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}
	
	@GetMapping("/fetchStudent")
	public List<Student> fetchStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/fetchStudent/{id}")
	public Student fetchStudentbyId(@PathVariable("id") Integer id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody Student student) {
		Student updatedStudent = studentRepository.findById(student.getRno()).orElse(null);
		if(updatedStudent != null) {
			updatedStudent.setName(student.getName());
			updatedStudent.setAddress(student.getAddress());
			studentRepository.save(updatedStudent);
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}
}
