package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Job;
import com.revature.repository.JobRepository;


//@DataJpaTest
@SpringBootTest(classes = {JobRepository.class,/* EntityManager.class, 
EntityManagerFactory.class*/}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
//@WebMvcTest(JobController.class)
//@ContextConfiguration(classes = InterviewServiceApplication.class)
/*@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	classes = InterviewServiceApplication.class)*/
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewServiceApplicationTests {
	@MockBean
	private TestEntityManager entityManager;
	
	//MockMvc mocMvc;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Test
	public void whenFindAll_thenReturn() {
		Job thisJob = new Job();
		entityManager.persist(thisJob);
		entityManager.flush();
		
		List<Job> found = (List<Job>) jobRepository.findAll();
		
		assertThat(found).contains(thisJob);
	}
	
	/*@Test
	public void getAll() throws Exception{
		Mockito.when(jr.findAll()).thenReturn(Collections.emptyList());
		
		this.mocMvc.perform(
				MockMvcRequestBuilders.get("/jobs/jobAll")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		verify(jr).findAll();
	}*/

}
