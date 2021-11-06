package com.revature.project2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tickets")
@Data 
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private int userId;
	private int showingId;
	
	
}