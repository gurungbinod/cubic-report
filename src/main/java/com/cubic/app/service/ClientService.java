package com.cubic.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.app.domain.Client;
import com.cubic.app.domain.User;
import com.cubic.app.repository.ClientDao;

@Service
public class ClientService  {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
	private ClientDao clientDao;
	
	public List<Client> getClientList() {
		logger.info("Getting list of Clients");
		return (List<Client>) clientDao.findAll();
	}
	
	public void save(Client c) {
		logger.info("Saving Client.."+c);
		clientDao.save(c);
	}
	
	public Client findById(int id) {
		logger.info("Getting client by id = "+id);
		return clientDao.findOne(id);
	}
}
