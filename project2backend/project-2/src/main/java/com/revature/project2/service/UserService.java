package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.User;

public interface UserService {
	public List<User> findAll();

	public User findByEmail(String email);

	public User findById(int userId);

	public void save(User user);

	public void update(int userId, User user);

	public void delete(int userId);

}