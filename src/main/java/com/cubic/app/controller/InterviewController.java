package com.cubic.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.app.domain.Interview;
import com.cubic.app.domain.InterviewRound;
import com.cubic.app.service.InterviewRoundService;
import com.cubic.app.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;
	
	@Autowired 
	private InterviewRoundService interviewRoundService;
	
	@RequestMapping("/list") 
	public List<Interview> getListOfInterview() {
		return interviewService.getInterviewList();
	}
	
	@RequestMapping("/ir/list") 
	public List<InterviewRound> getListOfInterviewInfo() {
		return interviewRoundService.getInterviewRoundsList();
	}
}
