package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Ticket;

public interface TicketService {
	public List<Ticket> findAll();

	public List<Ticket> findByUserId(int userId);

	public Ticket findById(int ticketId);

	public void save(Ticket ticket);

	public void update(int ticketId, Ticket ticket);

	public void delete(int ticketId);

}