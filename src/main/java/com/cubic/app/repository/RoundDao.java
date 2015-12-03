package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Round;

@Repository
public interface RoundDao extends CrudRepository<Round, Integer> {

}
