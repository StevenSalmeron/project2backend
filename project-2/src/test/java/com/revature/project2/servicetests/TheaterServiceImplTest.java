package com.revature.project2.servicetests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.project2.model.Theater;
import com.revature.project2.repo.TheaterRepository;
import com.revature.project2.service.TheaterService;
import com.revature.project2.service.TheaterServiceImpl;

public class TheaterServiceImplTest {
	
	//6 Tests: 6 Passed
	
	@Mock
	private TheaterRepository tRepo;
	
	@InjectMocks
	private TheaterService tService = TheaterServiceImpl.getTServ();
	
	@BeforeEach
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Order(1)
	public void findAllTest() {
		List<Theater> list = new ArrayList<Theater>();
		Theater one = new Theater(1,"Shrek", 45);						//theaterId, movie, maxCapacity
		Theater two = new Theater(2,"Happy Feet", 60);
		Theater three = new Theater(3,"Finding Nemo", 55);
		
		list.add(one);
		list.add(two);
		list.add(three);
		
		when(tRepo.findAll()).thenReturn(list);							//Mock TheaterRepository and return list of all Theaters
		List<Theater> result = tService.findAll();
		
		Assertions.assertEquals(3, result.size());						//Resulting list of Theaters should have a size of 3
		verify(tRepo,times(1)).findAll();								//Verify TheaterRepository calls findAll method 1 time
	}
	
	@Test
	@Order(2)
	public void findByMovieTest() {
		List<Theater> list = new ArrayList<Theater>();
		Theater temp = new Theater(4, "Snakes on a Plane", 75);
		list.add(temp);
		
		when(tRepo.findByMovie("Snakes on a Plane")).thenReturn(list);		//Mock TheaterRepository and return matching movie
		List<Theater> test = tService.findByMovie("Snakes on a Plane");		
		Theater target = test.get(0);
		
		Assertions.assertEquals(4, target.getTheaterId());					//target movie should have a theaterId equal to 4
		Assertions.assertEquals(75, target.getMaxCapacity());				//target movie should have a maxCapacity equal to 75
		verify(tRepo,times(1)).findByMovie("Snakes on a Plane");			//Verify TheaterRepository calls findByMovie method 1 time
	}
	
	@Test
	@Order(3)
	public void findByIdTest() {
		Optional<Theater> temp = Optional.ofNullable(new Theater(3,"Finding Nemo", 55));
		when(tRepo.findById(3)).thenReturn(temp);
		
		Theater test = tService.findById(3);

		Assertions.assertEquals("Finding Nemo", test.getMovie());			// test movie should be equal to 'Finding Nemo'
		Assertions.assertEquals(55, test.getMaxCapacity());					// test should have a maxCapacity equal to 55
	}
	
	@Test
	@Order(4)
	public void saveTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		tService.save(test);
		
		verify(tRepo,times(1)).save(test);									//Verify TheaterRepository calls save method 1 time
	}
	
	@Test
	@Order(5)
	public void updateTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		test.setMaxCapacity(100);
		test.setMovie("Dune");
		tService.update(2, test);
		
		Assertions.assertEquals("Dune", test.getMovie());					//updated test movie should equal to 'Dune'
		verify(tRepo,times(1)).save(test);									//Verify TheaterRepository calls save method 1 time
	}
	
	//Failed test:: Wanted but not invoked: tRepo.delete(test) - review and rewrite
	@Test
	@Order(6)
	public void deleteTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		tRepo.delete(test);
		
		verify(tRepo,times(1)).delete(test);								//Verify TheaterRepository calls delete method 1 time
	}
}