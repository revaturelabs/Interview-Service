package com.revature.controller;

import java.util.List;

import com.revature.model.Comment;
import com.revature.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/comment")
public class CommentController {
    @Autowired
    private CommentService cs;

    @PostMapping("/insert")
	public Comment insertComment(@RequestParam int id, @RequestBody Comment comment) {
			return cs.insertCommentWithInterview(id, comment);
    }
    
    @GetMapping("/getByInterview/{id}")
    public List<Comment> findByInterviewId(@PathVariable int id){
        return cs.getCommentsByInterview(id);
    }
}