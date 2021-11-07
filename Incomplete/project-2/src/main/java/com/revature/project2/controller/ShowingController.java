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

import com.revature.project2.model.Showing;
import com.revature.project2.service.ShowingService;

@RestController
public class ShowingController {
	@Autowired
	ShowingService showingService;

	@GetMapping("/showings")
	public List<Showing> findAll() {
		return showingService.findAll();
	}

	@GetMapping("/showingsByTheater/{theaterId}")
	public List<Showing> findByTheater(@PathVariable int theaterId) {
		return showingService.findByTheaterId(theaterId);
	}

	@GetMapping("/showings/{showingId}")
	public Showing findById(@PathVariable int showingId) {
		return showingService.findById(showingId);
	}

	@PostMapping("/showings")
	public void save(@RequestBody Showing showing) {
		showingService.save(showing);

	}

	@PostMapping("/showings/bulk")
	public void save(@RequestBody Showing[] showings) {
		for (Showing showing : showings) {
			showingService.save(showing);
		}
	}

	@PutMapping("/showings/{showingId}")
	public void update(@PathVariable int showingId, @RequestBody Showing showing) {
		showingService.save(showing);

	}

	@DeleteMapping("/showings/{showingId}")
	public void delete(@PathVariable int showingId) {
		showingService.delete(showingId);

	}

}