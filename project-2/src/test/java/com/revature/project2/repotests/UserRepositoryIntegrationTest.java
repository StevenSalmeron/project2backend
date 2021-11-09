package com.revature.project2.repotests;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project2.model.User;
import com.revature.project2.repo.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

	@Autowired
	UserRepository userRepo;
	
	@Test
	public void testRepository() {
		User temp = new User("johntsunami","john@gmail.com", "password");
		userRepo.save(temp);
		
		Assert.assertNotNull(temp.getId());
	}
}
