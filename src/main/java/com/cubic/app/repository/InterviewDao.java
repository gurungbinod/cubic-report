package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Interview;

@Repository
public interface InterviewDao extends CrudRepository<Interview, Integer> {

}
