package com.revature.controllers;


/**
 * @author Janel Williams 12/12/2019
 * Junit test for Interview service methods, tests layer methods. There was some trouble with the custom repository here.
 * Because it was the most complex entity relationship that we had. May need to instantiate a different kind of 
 * context for the cusom repo.  
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.InterviewController;
import com.revature.controller.UserController;
import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.model.User;
import com.revature.service.InterviewService;

//Configures spring context 
@SpringBootTest(classes = { InterviewController.class, InterviewService.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewControllerTest {

	@Autowired
	InterviewController ic;

	@Autowired
	InterviewService is;

	Set<Skill> skillset = new HashSet<>();
	Set<Profile> profileset = new HashSet<>();
	Set<Interview> interviewset = new HashSet<>();
	Set<User> userset = new HashSet<>();

	Profile profile1 = new Profile(1, "Fred", "Jenkins", "description");
	Profile profile2 = new Profile(2, "testfirst", "testlast", "description");
	Profile profile3 = new Profile(3, "anotherone", "anotherone", "description");

	Job job1 = new Job(1, "title1", "description", skillset, true);
	Job job2 = new Job(2, "title1", "description", skillset, true);
	Job job3 = new Job(3, "title1", "description", skillset, true);


	Interview interview1 = new Interview(1, profile1, Timestamp.from(Instant.now()), true,
		job1, userset);
	Interview interview2 = new Interview(2, profile2, Timestamp.from(Instant.now()), true,
		job2, userset);
		Interview interview3 = new Interview(3, profile3, Timestamp.from(Instant.now()), true,
		job3, userset);

	// Comment comment1 = new Comment(1, Timestamp.from(Instant.now()), "name", "text", interview1);
	// Comment comment2 = new Comment(2, Timestamp.from(Instant.now()), "name", "text", interview2);
		

	//Sets up Interview objects 
	@Before
	public void setUp() {
		User user1 = new User(0, "username", "passowrd", interviewset);
		User user2 = new User(2, "username1", "password", interviewset);

		Set<User> userset = new HashSet<>();
			userset.add(user1);
			userset.add(user2);
		
		ic.saveInterview(interview1);
		ic.saveInterview(interview2);
		
		
		
	}

	
	@Test
	public void testSetup() {
		//testing the set up 
		assertEquals(true, ic.saveInterview(is.insertInterviewInfo(i));
	}

	@Test
	public void testgetAll() {

		List<Interview> list = new ArrayList<>();
		list.add(interview1);
		list.add(interview2);

		//Can't compare the objects 
		assertEquals(list.iterator().next(), ic.getAll().iterator().next());
	}

	@Test
	public void getById() {

		assertEquals(ic.getById(1).getId(), interview1.getId());

	}

}