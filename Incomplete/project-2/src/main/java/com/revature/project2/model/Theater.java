package com.revature.project2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "theaters")
@Data 
@AllArgsConstructor // added for testing
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theaterId;
	private String movie;
	private int maxCapacity;
	
	
}