package com.craterzone.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.craterzone.model.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

	 public User findById(int id); 
}
