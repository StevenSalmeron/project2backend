package com.revature.project2.repotests;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project2.model.Ticket;
import com.revature.project2.repo.TicketRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketRepositoryIntegrationTest {

	@Autowired
	TicketRepository ticketRepo;
	
	@Test
	public void testRepository() {
		Ticket temp = new Ticket(1, 15, 3);
		ticketRepo.save(temp);
		
		Assert.assertNotNull(temp.getTicketId());			//Ticket should have a value for ticketId
	}
}
