package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer> {

}
