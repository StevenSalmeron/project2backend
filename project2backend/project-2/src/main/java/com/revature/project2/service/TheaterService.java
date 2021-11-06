package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Theater;

public interface TheaterService {
	public List<Theater> findAll();

	public Theater findById(int theaterId);

	public List<Theater> findByMovie(String movie);

	public void save(Theater theater);

	public void update(int theaterId, Theater theater);

	public void delete(int theaterId);

}