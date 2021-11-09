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

import com.revature.project2.model.Ticket;
import com.revature.project2.repo.TicketRepository;
import com.revature.project2.service.TicketService;
import com.revature.project2.service.TicketServiceImpl;

public class TicketServiceImplTest {

	//6 Tests: 1 Failure, 5 Passed
	//TODO: review failed test - rewrite if necessary
	
	@Mock
	private TicketRepository tRepo;
	
	@InjectMocks
	private TicketService tService = TicketServiceImpl.getTServ();
	
	@BeforeEach
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Order(1)
	
	public void findAllTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket one = new Ticket(1, 15, 3);
		Ticket two = new Ticket(2, 11, 2);
		Ticket three = new Ticket(3, 12, 4);
		
		list.add(one);
		list.add(two);
		list.add(three);
		
		Mockito.when(tRepo.findAll()).thenReturn(list);
		List<Ticket> result = tService.findAll();
		
		Assertions.assertEquals(3, result.size());
		verify(tRepo,times(1)).findAll();
	}
	
	@Test
	@Order (2)
	
	public void findByUserIdTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket temp = new Ticket(3, 12, 4);
		list.add(temp);
	
		when(tRepo.findByUserId(12)).thenReturn(list);
		List<Ticket> test = tService.findByUserId(12);
		Ticket target = test.get(0);
		
		Assertions.assertEquals(3, target.getTicketId());
		Assertions.assertEquals(4, target.getShowingId());
		verify(tRepo,times(1)).findByUserId(12);
		
	}
	
	@Test
	@Order (3)
	
	public void findByIdTest() {
		Optional<Ticket> temp = Optional.ofNullable(new Ticket(3, 12, 4));
		when(tRepo.findById(3)).thenReturn(temp);
		
		Ticket test = tService.findById(3);
		
		Assertions.assertEquals(4, test.getShowingId());
		Assertions.assertEquals(12, test.getUserId());
		
	}
	
	@Test
	@Order (4)
	
	public void saveTest() {
		Ticket test = new Ticket(3, 12, 4);
		tService.save(test);
		
		verify(tRepo,times(1)).save(test);
	}
	
	@Test
	@Order (5)
	
	public void updateTest() {
		Ticket test = new Ticket(3, 12, 4);
		test.setShowingId(3);
		tService.update(3, test);
		
		Assertions.assertEquals(3, test.getShowingId());
		verify(tRepo,times(1)).save(test);
	}
	
	
	//Failed test:: Wanted but not invoked: tRepo.delete(test) - review and rewrite
	@Test
	@Order (6)
	public void deleteTest() {
		Ticket test = new Ticket(3, 12, 4);
		tService.delete(3);

		verify(tRepo,times(1)).delete(test);
	}
}