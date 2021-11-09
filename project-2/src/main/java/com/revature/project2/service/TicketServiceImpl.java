package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Ticket;
import com.revature.project2.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	private static TicketService tServ = null;

	public static TicketService getTServ() {
		if (tServ == null)
			tServ = new TicketServiceImpl();
		return tServ;
	}
	
	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> findByUserId(int userId) {
		return ticketRepository.findByUserId(userId);
	}

	@Override
	public Ticket findById(int ticketId) {
		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);

	}

	@Override
	public void update(int ticketId, Ticket ticket) {
		ticketRepository.save(ticket);

	}

	@Override
	public void delete(int ticketId) {
		ticketRepository.deleteById(ticketId);

	}

}