package com.revature.project2.repotests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project2.model.Showing;
import com.revature.project2.repo.ShowingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShowingRepositoryIntegrationTest {

	@Autowired
	ShowingRepository showRepo;
	
	@Test
	public void testRepository() {
		Showing temp = new Showing(1, 2, "12:30", "45");
		showRepo.save(temp);
		
		Assert.assertNotNull(temp.getShowingId());
	}
}
