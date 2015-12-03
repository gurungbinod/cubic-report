package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Technology;

@Repository
public interface TechnologyDao extends CrudRepository<Technology, Integer> {

}
