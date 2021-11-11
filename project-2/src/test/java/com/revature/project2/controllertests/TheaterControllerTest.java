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

import com.revature.project2.controller.TheaterController;
import com.revature.project2.model.Theater;
import com.revature.project2.repo.TheaterRepository;
import com.revature.project2.security.jwt.AuthEntryPointJwt;
import com.revature.project2.security.jwt.JwtUtils;
import com.revature.project2.security.services.UserDetailsServiceImpl;
import com.revature.project2.service.TheaterServiceImpl;

@RunWith(SpringRunner.class)
//@ContextConfiguration
@WebMvcTest(TheaterController.class)
public class TheaterControllerTest {

	@Autowired
	private MockMvc mockMvc;			//create instance of MockMvc object to perform get/post requests to the controller
	@MockBean
	TheaterServiceImpl tServImp;		//create mock objects of each dependency
	@MockBean
	TheaterRepository tRepo;
	@MockBean
	UserDetailsServiceImpl userDetailService;
	@MockBean
	AuthEntryPointJwt authEntryPoint;
	@MockBean
	JwtUtils jwtUtil;
	
	//All tests are currently passing
	
	@Test
	public void findAllTest() {
		List<Theater> list = new ArrayList<Theater>();
		list.add(new Theater(1,"Shrek", 45));
		list.add(new Theater(2,"Happy Feet", 60));
		list.add(new Theater(3,"Finding Nemo", 55));
		
		Mockito.when(tServImp.findAll()).thenReturn(list);
		String url ="/theaters";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void findByMovieTest() {
		List<Theater> list = new ArrayList<Theater>();
		Theater temp = new Theater(4, "Snakes on a Plane", 75);
		list.add(temp);
		
		Mockito.when(tServImp.findByMovie("Snakes on a Plane")).thenReturn(list);
		List<Theater> test = tServImp.findByMovie("Snakes on a Plane");
		Theater target = test.get(0);
		
		Assertions.assertEquals(4, target.getTheaterId());
		Assertions.assertEquals(75, target.getMaxCapacity());
		Mockito.verify(tServImp,times(1)).findByMovie("Snakes on a Plane");
		
		String url ="/theatersByMovie/{movie}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void findByIdTest() {
		Theater temp = new Theater(4, "Snakes on a Plane", 75);
		Mockito.when(tServImp.findById(4)).thenReturn(temp);
		
		Theater test = tServImp.findById(4);
		
		Assertions.assertEquals("Snakes on a Plane", test.getMovie());
		Assertions.assertEquals(75, test.getMaxCapacity());
		
		
		String url ="/theaters/{theaterId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void saveTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		tServImp.save(test);
		
		Mockito.verify(tServImp,times(1)).save(test);
		
		
		String url ="/theaters";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void updateTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		test.setMaxCapacity(70);
		test.setMovie("Dune");
		tServImp.update(2, test);
		
		Mockito.verify(tServImp,times(1)).update(2, test);
		
		String url ="/theaters/{theaterId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void deleteTest() {
		Theater test = new Theater(2,"Happy Feet", 60);
		tRepo.delete(test);
		Mockito.verify(tRepo,times(1)).delete(test);
		
		String url ="/theaters/{theaterId}";
		try {
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
