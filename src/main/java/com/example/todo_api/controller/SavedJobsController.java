package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.SavedJobs;

@RestController
@RequestMapping("/saved-jobs")
public class SavedJobsController {
	
	@PostMapping("/")
	public String saveJob(@RequestBody SavedJobs savedJob) {
		return "Sucess";
	}

}
