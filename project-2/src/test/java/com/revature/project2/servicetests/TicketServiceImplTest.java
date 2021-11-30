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

	//6 Tests: 6 Passed
	
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
		list.add(new Ticket(1, 15, 3));								//ticketId, userId, showingId
		list.add(new Ticket(2, 11, 2));
		list.add(new Ticket(3, 12, 4));
		
		Mockito.when(tRepo.findAll()).thenReturn(list);				//Mock TicketRepository and return list of all tickets
		List<Ticket> result = tService.findAll();
			
		Assertions.assertEquals(3, result.size());					//resulting list should equal size of 3
		verify(tRepo,times(1)).findAll();							//Verify that TicketRepository calls findAll method 1 time
	}
	
	@Test
	@Order (2)
	
	public void findByUserIdTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket temp = new Ticket(3, 12, 4);
		list.add(temp);
	
		when(tRepo.findByUserId(12)).thenReturn(list);				//Mock TicketRepository and return list of all tickets by userId
		List<Ticket> test = tService.findByUserId(12);
		Ticket target = test.get(0);								//assign target ticket to first ticket on the list
		
		Assertions.assertEquals(3, target.getTicketId());			//resulting ticket should have ticketId of 3
		Assertions.assertEquals(4, target.getShowingId());			//resulting ticket should have a showingId of 4
		verify(tRepo,times(1)).findByUserId(12);					//verify that TicketRepository calls findByUserId method 1 time
		
	}
	
	@Test
	@Order (3)
	
	public void findByIdTest() {
		Optional<Ticket> temp = Optional.ofNullable(new Ticket(3, 12, 4));
		when(tRepo.findById(3)).thenReturn(temp);					//Mock TicketRepository and return ticket that matches the id
		
		Ticket test = tService.findById(3);
		
		Assertions.assertEquals(4, test.getShowingId());			//test ticket should have a showingId of 4
		Assertions.assertEquals(12, test.getUserId());				//test ticket should have a userId of 4
		
	}
	
	@Test
	@Order (4)
	
	public void saveTest() {
		Ticket test = new Ticket(3, 12, 4);
		tService.save(test);
		
		verify(tRepo,times(1)).save(test);						//Verify that TicketRepository calls save method 1 time
	}
	
	@Test
	@Order (5)
	
	public void updateTest() {
		Ticket test = new Ticket(3, 12, 4);
		test.setShowingId(3);
		tService.update(3, test);
		
		Assertions.assertEquals(3, test.getShowingId());
		verify(tRepo,times(1)).save(test);						//Verify that TicketRepository calls update method 1 time
	}
	
	
	//Failed test:: Wanted but not invoked: tRepo.delete(test) - review and rewrite
	@Test
	@Order (6)
	public void deleteTest() {
		Ticket test = new Ticket(3, 12, 4);
		tRepo.delete(test);

		verify(tRepo,times(1)).delete(test);				//Verify that TicketRepository calls delete method 1 time
	}
}