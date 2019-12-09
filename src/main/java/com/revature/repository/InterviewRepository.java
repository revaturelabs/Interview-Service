package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.revature.model.Interview;

/**
 * A simple Interview Repo Interface.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
	Interview findById(int id);
}
