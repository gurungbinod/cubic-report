package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.InterviewRound;
import com.cubic.app.domain.User;
import com.cubic.app.repository.InterviewRoundDao;

@Service
public class InterviewRoundService {

	private static final Logger logger = LoggerFactory.getLogger(InterviewRoundService.class);
	
	@Autowired
	private InterviewRoundDao interviewRoundDao;
	
	public List<InterviewRound> getInterviewRoundsList(){
		logger.info("Getting list of Interview Rounds");
		return (List<InterviewRound>) interviewRoundDao.findAll();
	}
	
	public void save(InterviewRound ir) {
		logger.info("Saving Intervew Round .. "+ir);
		interviewRoundDao.save(ir);
		
	}
}
