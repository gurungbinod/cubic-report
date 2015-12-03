package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.Candidate;
import com.cubic.app.domain.User;
import com.cubic.app.repository.CandidateDao;

@Service
public class CandidateService {
	private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);
	
	@Autowired
	private CandidateDao candidateDao;
	
	public List<Candidate> getCandidateList() {
		logger.info("Getting list of Candidates");
		return (List<Candidate>) candidateDao.findAll();
	}
	
	public void save(Candidate c) {
		logger.info("Saving Candidate.. " +c);
		candidateDao.save(c);
		
	}
	public Candidate findOne(int id) {
		logger.info("Find Candidate By id: "+id);
		return candidateDao.findOne(id);
	}
}
