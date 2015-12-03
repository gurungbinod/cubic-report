package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.Round;
import com.cubic.app.domain.User;
import com.cubic.app.repository.RoundDao;

@Service
public class RoundService {
	private static final Logger logger = LoggerFactory
			.getLogger(CandidateService.class);
	
	@Autowired
	private RoundDao roundDao;

	public List<Round> getListOfRounds() {
		logger.info("Getting list of rounds..");
		return (List<Round>) roundDao.findAll();
	}
	public void save(Round r) {
		logger.info("Saving round.."+r);
		roundDao.save(r);
		
	}
	public Round findOne(int id){
		logger.info("Find Round by id: "+id);
		return roundDao.findOne(id);
	}
 }
