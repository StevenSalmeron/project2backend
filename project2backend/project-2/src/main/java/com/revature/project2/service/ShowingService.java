package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Showing;

public interface ShowingService {
	public List<Showing> findAll();

	public List<Showing> findByTheaterId(int theaterId);

	public Showing findById(int showingId);

	public void save(Showing showing);

	public void update(int showingId, Showing showing);

	public void delete(int showingId);

}