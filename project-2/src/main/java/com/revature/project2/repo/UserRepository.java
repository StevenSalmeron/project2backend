package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByEmail(String email);
}
