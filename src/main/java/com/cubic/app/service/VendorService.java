package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.User;
import com.cubic.app.domain.Vendor;
import com.cubic.app.repository.VendorDao;

@Service
public class VendorService {
	private static final Logger logger = LoggerFactory
			.getLogger(CandidateService.class);
	
	@Autowired
	private VendorDao vendorDao;
	
	public List<Vendor> getListOfVendor() {
		logger.info("Getting list of vendors..");
		return (List<Vendor>) vendorDao.findAll();
	}
	
	public void save(Vendor v) {
		logger.info("Saving Vendor.."+v);
		vendorDao.save(v);
	}
	
	public Vendor findById(int id){
		logger.info("Find Vendor By Id: "+id);
		return vendorDao.findOne(id);
	}
}
