package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.User;
import com.revature.project2.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	// Added for testing
	private static UserService userv = null;

	public static UserService getUserv() {
		if (userv == null)
			userv = new UserServiceImpl();
		return userv;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public void update(int userId, User user) {
		userRepository.save(user);

	}

	@Override
	public void delete(int userId) {
		userRepository.deleteById(userId);

	}

}