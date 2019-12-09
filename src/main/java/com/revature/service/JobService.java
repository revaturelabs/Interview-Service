package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Job;
import com.revature.repository.JobRepository;

/**
 * The service layer (or business logic) for the Job object.
 * 
 * @author Adriana Long
 */
@Service
public class JobService {
	@Autowired
	private JobRepository jr;

	public JobService(JobRepository jr) {
		this.jr = jr;
	}

	public boolean insertJobInfo(Job j) {
		try {
			jr.save(j);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateJobInfo(Job p) {
		try {
			Job b;
			int id = p.getId();
			b = jr.findById(id);
			b.setFilled(true);
			jr.save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Iterable<Job> getAllJobs() {
		return jr.findAll();
	}

	public Job findById(int id) {
		return jr.findById(id);
	}

	public Job findByTitle(String title) {
		return jr.findByTitle(title);
	}

	public Iterable<Job> findAll() {
		return jr.findAll();
	}
}
