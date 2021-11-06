package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
	public List<Theater> findByMovie(String movie);
}
