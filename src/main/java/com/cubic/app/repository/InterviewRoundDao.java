package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.InterviewRound;

@Repository
public interface InterviewRoundDao extends CrudRepository<InterviewRound, Integer> {

}
