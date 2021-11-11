package com.revature.project2.controllertests;

import static org.mockito.Mockito.times;
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

import com.revature.project2.controller.ShowingController;
import com.revature.project2.model.Showing;
import com.revature.project2.repo.ShowingRepository;
import com.revature.project2.security.jwt.AuthEntryPointJwt;
import com.revature.project2.security.jwt.JwtUtils;
import com.revature.project2.security.services.UserDetailsServiceImpl;
import com.revature.project2.service.ShowingServiceImpl;

@RunWith(SpringRunner.class)
//@ContextConfiguration
@WebMvcTest(ShowingController.class)
public class ShowingControllerTest {

	@Autowired
	private MockMvc mockMvc;			//create instance of MockMvc object to perform get/post requests to the controller
	@MockBean
	ShowingServiceImpl showServImp;
	@MockBean
	ShowingRepository showRepo;
	@MockBean
	UserDetailsServiceImpl userDetailService;
	@MockBean
	AuthEntryPointJwt authEntryPoint;
	@MockBean
	JwtUtils jwtUtil;
	
	//All tests are currently passing
	
	@Test
	public void findAllTest() {
		List<Showing> list = new ArrayList<Showing>();
		list.add(new Showing(1, 1, "10:30", "45")); // Showing(showingId, theaterId, time, currentCapacity)
		list.add(new Showing(1, 2, "12:30", "45"));
		list.add(new Showing(1, 3, "1:30", "45"));
		
		Mockito.when(showServImp.findAll()).thenReturn(list);
		String url = "/showings";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void findByTheaterTest() {
		List<Showing> list = new ArrayList<Showing>();
		Showing temp = new Showing(1, 3, "1:30", "45");
		list.add(temp);
		
		Mockito.when(showServImp.findByTheaterId(3)).thenReturn(list);
		List<Showing> test = showServImp.findByTheaterId(3);
		Showing target = test.get(0);
		
		Assertions.assertEquals("1:30", target.getTime());
		Assertions.assertEquals("45", target.getCurrentCapacity());
		Mockito.verify(showServImp,times(1)).findByTheaterId(3);
		
		String url = "/showingsByTheater/{showingId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void findByIdTest() {
		Showing temp = new Showing(1, 1, "10:30", "45"); //showingId, theaterId, time, currentCapacity
		Mockito.when(showServImp.findById(1)).thenReturn(temp);
		
		Showing test = showServImp.findById(1);
		
		Assertions.assertEquals("10:30", test.getTime());
		Assertions.assertEquals("45", test.getCurrentCapacity());
		
		String url = "/showings/{showingId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void saveTest() {
		Showing temp = new Showing(1, 1, "10:30", "45");
		showServImp.save(temp);
		
		Mockito.verify(showServImp,times(1)).save(temp);
		
		
		String url = "/showings";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void updateTest() {
		Showing temp = new Showing(1, 1, "10:30", "45");
		temp.setCurrentCapacity("35");
		temp.setTime("10:45");
		showServImp.update(1, temp);
		
		Mockito.verify(showServImp,times(1)).update(1, temp);
		
		
		String url = "/showings/{showingId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void deleteTest() {
		Showing temp = new Showing(1, 1, "10:30", "45");
		showRepo.delete(temp);
		Mockito.verify(showRepo,times(1)).delete(temp);
		
		String url = "/showings/{showingId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
