package com.revature.project2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "showings")
@Data
@AllArgsConstructor // added for testing
@NoArgsConstructor // added for testing
public class Showing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showingId;
	private int theaterId;
	private String time;
	private String currentCapacity;

}