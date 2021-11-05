package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Showing;
import com.revature.project2.repo.ShowingRepository;

@Service
public class ShowingServiceImpl implements ShowingService {

	@Autowired
	ShowingRepository showingRepository;

	@Override
	public List<Showing> findAll() {
		return showingRepository.findAll();
	}

	@Override
	public List<Showing> findByTheaterId(int theaterId) {
		return showingRepository.findByTheaterId(theaterId);
	}

	@Override
	public Showing findById(int showingId) {
		return showingRepository.findById(showingId).get();
	}

	@Override
	public void save(Showing showing) {
		showingRepository.save(showing);

	}

	@Override
	public void update(int showingId, Showing showing) {
		showingRepository.save(showing);

	}

	@Override
	public void delete(int showingId) {
		showingRepository.deleteById(showingId);

	}

}