	package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Candidate;

@Repository
public interface CandidateDao extends CrudRepository<Candidate, Integer> {

}
