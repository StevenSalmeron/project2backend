package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Theater;
import com.revature.project2.repo.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	TheaterRepository theaterRepository;

	@Override
	public List<Theater> findAll() {
		return theaterRepository.findAll();
	}

	@Override
	public List<Theater> findByMovie(String movie) {
		return theaterRepository.findByMovie(movie);
	}

	@Override
	public Theater findById(int theaterId) {
		return theaterRepository.findById(theaterId).get();
	}

	@Override
	public void save(Theater theater) {
		theaterRepository.save(theater);

	}

	@Override
	public void update(int theaterId, Theater theater) {
		theaterRepository.save(theater);

	}

	@Override
	public void delete(int theaterId) {
		theaterRepository.deleteById(theaterId);

	}

}