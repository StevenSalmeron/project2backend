package com.revature.project2.repotests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project2.model.Theater;
import com.revature.project2.repo.TheaterRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TheaterRepositoryIntegrationTest {

	@Autowired
	TheaterRepository theaterRepo;
	
	@Test
	public void testRepository() {
		Theater temp = new Theater(1,"Shrek", 45);
		theaterRepo.save(temp);
		
		Assert.assertNotNull(temp.getTheaterId());
	}
}
