package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.Interview;
import com.cubic.app.domain.User;
import com.cubic.app.repository.InterviewDao;

@Service
public class InterviewService {

	private static final Logger logger = LoggerFactory
			.getLogger(CandidateService.class);

	@Autowired
	private InterviewDao interviewDao;

	public List<Interview> getInterviewList() {
		logger.info("Getting list of Interviews");
		return (List<Interview>) interviewDao.findAll();
	}
	
	public void save(Interview i) {
		logger.info("Saving Interview.. "+i);
		interviewDao.save(i);
		
	}
	public Interview findOne(int id) {
		logger.info("Find Interview by id: "+id);
		return interviewDao.findOne(id);
	}
	
}
