package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.Showing;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
	public List<Showing> findByTheaterId(int theaterId);
}
