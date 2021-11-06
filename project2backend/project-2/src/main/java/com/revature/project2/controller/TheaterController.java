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

import com.revature.project2.model.Theater;
import com.revature.project2.service.TheaterService;

@RestController
public class TheaterController {
	@Autowired
	TheaterService theaterService;

	@GetMapping("/theaters")
	public List<Theater> findAll() {
		return theaterService.findAll();
	}

	@GetMapping("/theatersByMovie/{movie}")
	public List<Theater> findByMovie(@PathVariable String movie) {
		return theaterService.findByMovie(movie);
	}

	@GetMapping("/theaters/{theaterId}")
	public Theater findById(@PathVariable int theaterId) {
		return theaterService.findById(theaterId);
	}

	@PostMapping("/theaters")
	public void save(@RequestBody Theater theater) {
		theaterService.save(theater);

	}

	@PostMapping("/theaters/bulk")
	public void save(@RequestBody Theater[] theaters) {
		for (Theater theater : theaters) {
			theaterService.save(theater);
		}
	}

	@PutMapping("/theaters/{theaterId}")
	public void update(@PathVariable int theaterId, @RequestBody Theater theater) {
		theaterService.save(theater);

	}

	@DeleteMapping("/theaters/{theaterId}")
	public void delete(@PathVariable int theaterId) {
		theaterService.delete(theaterId);

	}

}