package com.revature.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.model.User;
import com.revature.project2.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/usersByEmail/{email}")
	public List<User> findByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/users/{userId}")
	public User findById(@PathVariable int userId) {
		return userService.findById(userId);
	}

	@PostMapping("/users")
	public void save(@RequestBody User user) {
		userService.save(user);

	}

	@PostMapping("/users/bulk")
	public void save(@RequestBody User[] users) {
		for (User user : users) {
			userService.save(user);
		}
	}

	@PutMapping("/users/{userId}")
	public void update(@PathVariable int userId, @RequestBody User user) {
		userService.save(user);

	}

	@DeleteMapping("/users/{userId}")
	public void delete(@PathVariable int userId) {
		userService.delete(userId);

	}

}