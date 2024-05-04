package com.slm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slm.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
	
	
}
