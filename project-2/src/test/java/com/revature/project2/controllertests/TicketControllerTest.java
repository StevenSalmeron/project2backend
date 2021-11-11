package com.revature.project2.controllertests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.project2.controller.TicketController;
import com.revature.project2.model.Ticket;
import com.revature.project2.repo.TicketRepository;
import com.revature.project2.security.jwt.AuthEntryPointJwt;
import com.revature.project2.security.jwt.JwtUtils;
import com.revature.project2.security.services.UserDetailsServiceImpl;
import com.revature.project2.service.TicketServiceImpl;

@RunWith(SpringRunner.class)
//@ContextConfiguration
@WebMvcTest(TicketController.class)
public class TicketControllerTest {

	@Autowired
	private MockMvc mockMvc; 					// create instance of MockMvc object to perform get/post requests to the controller
	@MockBean
	TicketServiceImpl tServImp;					// create mock objects of each dependency
	@MockBean
	UserDetailsServiceImpl userDetailService;
	@MockBean
	AuthEntryPointJwt authEntryPoint;
	@MockBean
	JwtUtils jwtUtil;
	@MockBean
	TicketRepository tRepo;

	//5 out of 6 tests are passing
	//failed test is marked
	
	@Test
	public void findAllTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		list.add(new Ticket(1, 15, 3));
		list.add(new Ticket(2, 11, 2));
		list.add(new Ticket(3, 12, 4));
		
		Mockito.when(tServImp.findAll()).thenReturn(list);
		String url = "/tickets";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void findByUserIdTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		list.add(new Ticket(3, 12, 4));
		
		Mockito.when(tServImp.findByUserId(12)).thenReturn(list);
		List<Ticket> test = tServImp.findByUserId(12);
		Ticket target = test.get(0);
		
		Assertions.assertEquals(3, target.getTicketId());
		Assertions.assertEquals(4, target.getShowingId());
		verify(tServImp,times(1)).findByUserId(12);
		
		String url = "/ticketsByUser/{userId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Test fails: Wanted but not invoked
	@Test
	public void findByIdTest() {
		Ticket temp = new Ticket(3, 12, 4);

		
		Mockito.when(tServImp.findById(3)).thenReturn(temp);
		verify(tServImp,times(1)).findById(3);
		
		String url = "/tickets/{ticketId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void saveTest() {
		Ticket test = new Ticket(3, 12, 4); // ticketId, userId, showingId
		tServImp.save(test);
		
		Mockito.verify(tServImp,times(1)).save(test);
		
		String url = "/tickets";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void updateTest() {
		Ticket test = new Ticket(3, 12, 4);
		test.setShowingId(6);
		tServImp.update(3, test);
		
		Assertions.assertEquals(12, test.getUserId());
		Mockito.verify(tServImp,times(1)).update(3, test);
		
		String url = "/tickets/{ticketId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void deleteTest() {
		Ticket test = new Ticket(3, 12, 4);
		tRepo.delete(test);
		Mockito.verify(tRepo,times(1)).delete(test);
		
		
		String url = "/tickets/{ticketId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
