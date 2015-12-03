package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.InterviewType;
import com.cubic.app.domain.User;
import com.cubic.app.repository.InterviewTypeDao;

@Service
public class InterviewTypeService {
	private static final Logger logger = LoggerFactory
			.getLogger(CandidateService.class);
	
	@Autowired
	private InterviewTypeDao interviewTypeDao;
	
	public List<InterviewType> getListOfInterviewTypes() {
		logger.info("Getting list of interview types..");
		return (List<InterviewType>) interviewTypeDao.findAll();
	}
	
	public void save(InterviewType it) {
		logger.info("Saving Interview Type.. "+it);
		interviewTypeDao.save(it);
		
	}
	public InterviewType findById(int id) {
		logger.info("Find Interview Type by id: "+id);
		return interviewTypeDao.findOne(id);
	}
}
