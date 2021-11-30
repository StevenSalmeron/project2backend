package com.revature.project2.servicetests;

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
	 *  6 tests -  6 Passed
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
		List<User> list = new ArrayList<>();
		list.add(new User("johnnytsunami","john@gmail.com", "password"));
		list.add(new User("susiecakes","susan@gmail.com","test"));
		list.add(new User("thedon","don@gmail.com", "num123"));
		
		Mockito.when(repo.findAll()).thenReturn(list);						//mock UserRepository to return list of all users
		List<User> result = service.findAll();								
		
		Mockito.verify(repo,times(1)).findAll();							//verify UserRepository calls findAll method 1 time
		Assertions.assertNotEquals(0, result.size());						//assert that result list is not empty
	}
	

	@Test
	@Order(2)
	public void findByEmailTest() {
		
		List<User> list = new ArrayList<User>();					//create a list
		list.add(new User("susiecakes","susan@gmail.com","test"));	//add new user to list
		
		when(repo.findByEmail("susan@gmail.com")).thenReturn(list);		//when repository object finds email, return list of values
		List<User> test = service.findByEmail("susan@gmail.com");		//create a test list and set equal to the values returned by findByEmail method
		User target = test.get(0);										//create a user and set it equal to first value in the list
		
		Assertions.assertEquals("susiecakes", target.getUsername());	//assert that username matches
		Assertions.assertEquals("test", target.getPassword());			//assert  password matches
		
	}
	
	
	@Test
	@Order(3)
	public void saveTest() {
		User test = new User("test","test@gmail.com","password");
		service.save(test);
		Mockito.verify(repo,times(1)).save(test);						//verify UserRepository calls save method 1 time
	}
	
	
	@Test
	@Order(4)
	public void findByIdTest() {
		Optional<User> temp = Optional.ofNullable(new User("thedon","don@gmail.com", "num123"));
		when(repo.findById(3)).thenReturn(temp);
		
		User test = service.findById(3);
		
		Mockito.verify(repo,times(1)).findById(3);						//verify UserRepository calls findById method 1 time
		Assertions.assertEquals("don@gmail.com", test.getEmail());		//the user that was returned by findById should have an email equal to 'don@gmail.com'
		Assertions.assertEquals("num123", test.getPassword());			//the user that was returned by findById should have a password equal to 'num123'
		
	}
	
	@Test
	@Order(5)
	public void update() {
		User test = new User("test","test@gmail.com","password");
		test.setEmail("test@yahoo.com");
		service.update(0, test);
		Mockito.verify(repo,times(1)).save(test);						//verify UserRepository calls update method 1 time
	}
	
	
	@Test
	@Order(6)
	public void delete() {
		User test = new User("test","test@gmail.com","password");
		repo.delete(test);
		Mockito.verify(repo,times(1)).delete(test);						//verify UserRepository calls delete method 1 time
	}
}

