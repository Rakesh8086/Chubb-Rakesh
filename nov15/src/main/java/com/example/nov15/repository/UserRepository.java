package com.example.nov15.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nov15.request.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
