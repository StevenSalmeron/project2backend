package com.revature.project2.controllertests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project2.controller.UserController;
import com.revature.project2.model.User;
import com.revature.project2.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@MockBean
	UserService uServ;
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserController controller;
	@Autowired
	ObjectMapper mapper;
	
	//Both 2 tests result in error- failed to load ApplicationContext - most likely due to wrong/missing classpath
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

	@Test
	public void validEndpoints() throws Exception {
		mockMvc.perform(get("/users").contentType("application/json")).andExpect(status().isOk());
		mockMvc.perform(post("/users").contentType("application/json")).andExpect(status().isOk());
	}
	
	//Test in progress
	
//	@Test
//	public void testSaveUser() throws Exception {
//		User mockUser = new User();
//		mockUser.setId(1l);
//		mockUser.setUsername("tester");
//		mockUser.setEmail("test@gmail.com");
//		mockUser.setPassword("password");
//		
//		String inputInJson = mapper.writeValueAsString(mockUser);
//		String URI = "/users";
//		Mockito.when(uServ.save(Mockito.any(User.class))).thenReturn(mockUser);
//		
//	}

}
