package com.revature.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.User;
import com.revature.repo.InterviewRepository;



/**
 * An object representation of our Interview model.
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */
@Service
public class InterviewService {

    @Autowired
    private InterviewRepository repository;


    public void  InsertInterviewInfo(Interview b) {
        repository.save(b);
    }


	
    
    
    
    
    
}