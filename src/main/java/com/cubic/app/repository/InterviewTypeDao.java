package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.InterviewType;

@Repository
public interface InterviewTypeDao extends CrudRepository<InterviewType, Integer> {

}
