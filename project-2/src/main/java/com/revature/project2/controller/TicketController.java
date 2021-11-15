package com.revature.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.model.Ticket;
import com.revature.project2.service.TicketService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TicketController {
	@Autowired
	TicketService ticketService;

	@GetMapping("/tickets")
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}

	@GetMapping("/ticketsByUser/{userId}")
	public List<Ticket> findByUserId(@PathVariable int userId) {
		return ticketService.findByUserId(userId);
	}

	@GetMapping("/tickets/{ticketId}")
	public Ticket findById(@PathVariable int ticketId) {
		return ticketService.findById(ticketId);
	}

	@PostMapping("/tickets")
	public void save(@RequestBody Ticket ticket) {
		ticketService.save(ticket);

	}

	@PostMapping("/tickets/bulk")
	public void save(@RequestBody Ticket[] tickets) {
		for (Ticket ticket : tickets) {
			ticketService.save(ticket);
		}
	}

	@PutMapping("/tickets/{ticketId}")
	public void update(@PathVariable int ticketId, @RequestBody Ticket ticket) {
		ticketService.save(ticket);

	}

	@DeleteMapping("/tickets/{ticketId}")
	public void delete(@PathVariable int ticketId) {
		ticketService.delete(ticketId);

	}

}