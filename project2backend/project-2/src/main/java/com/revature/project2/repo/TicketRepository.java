package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	public List<Ticket> findByUserId(int userId);
}
