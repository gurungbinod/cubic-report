package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.Technology;
import com.cubic.app.repository.TechnologyDao;

@Service
public class TechnologyService {
	private static final Logger logger = LoggerFactory
			.getLogger(CandidateService.class);
	
	@Autowired
	private TechnologyDao technologyDao;
	
	public List<Technology> getListOfTechnology() {
		logger.info("Getting list of Technologies..");
		return (List<Technology>) technologyDao.findAll();
	}
	
	public void save(Technology t) {
		logger.info("Saving technology.. "+t);
		technologyDao.save(t);
	}
	
	public Technology findById(int id){
		logger.info("Find Technology by id: "+id);
		return technologyDao.findOne(id);
	}
}
