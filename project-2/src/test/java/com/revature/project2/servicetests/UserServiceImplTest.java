package com.revature.project2.servicetests;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
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

import com.revature.project2.model.User;
import com.revature.project2.repo.UserRepository;
import com.revature.project2.service.UserService;
import com.revature.project2.service.UserServiceImpl;


public class UserServiceImplTest {
	/*
	 *  6 tests-  1 Failed, 5 Passed
	 * tests that did not pass are marked
	 * 
	 *  TODO: review failed test - rewrite if necessary
	 */
	@Mock
	private UserRepository repo;
	
	@InjectMocks
	private UserService service = UserServiceImpl.getUserv();
	
	@BeforeEach
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Order(1)
	public void findAllTest() {
		List<User> list = new ArrayList<User>();			
		User one = new User("johnnytsunami","john@gmail.com", "password");
		User two = new User("susiecakes","susan@gmail.com","test");
		User three = new User("thedon","don@gmail.com", "num123");
		
		list.add(one);
		list.add(two);
		list.add(three);
		
		Mockito.when(repo.findAll()).thenReturn(list);
		List<User> result = service.findAll();
		
		Assertions.assertNotEquals(0, result.size());
	}
	

//	@Test
//	@Order(2)
//	public void findByEmailTest() {
//		User temp = new User("susiecakes","susan@gmail.com","test");
//		when(repo.findByEmail("susan@gmail.com")).thenReturn(temp);
//		
//		User test = service.findByEmail("susan@gmail.com");
//		
//		Assertions.assertEquals("test", test.getPassword());
//		Assertions.assertEquals(2, test.getId());
//	}
	
	
	@Test
	@Order(3)
	public void saveTest() {
		User test = new User("test","test@gmail.com","password");
		service.save(test);
		Mockito.verify(repo,times(1)).save(test);	
	}
	
	
	@Test
	@Order(4)
	public void findByIdTest() {
		Optional<User> temp = Optional.ofNullable(new User("thedon","don@gmail.com", "num123"));
		when(repo.findById(3)).thenReturn(temp);
		
		User test = service.findById(3);
		
		Assertions.assertEquals("don@gmail.com", test.getEmail());
		Assertions.assertEquals("num123", test.getPassword());
		
	}
	
	@Test
	@Order(5)
	public void update() {
		User test = new User("test","test@gmail.com","password");
		test.setEmail("test@yahoo.com");
		service.update(0, test);
		Mockito.verify(repo,times(1)).save(test);
	}
	
	//Failed test:: Wanted but not invoked: repo.delete(test) - review and rewrite
	@Test
	@Order(6)
	public void delete() {
		User test = new User("test","test@gmail.com","password");
		service.delete(0);
		Mockito.verify(repo,times(1)).delete(test);
	}
}

