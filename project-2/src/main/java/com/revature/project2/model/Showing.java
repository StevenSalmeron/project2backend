package com.revature.project2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "showings")
@Data 
public class Showing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showingId;
	private int theaterId;
	private String time;
	private String currentCapacity;
	
}