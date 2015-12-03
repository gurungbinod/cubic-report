package com.cubic.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.app.domain.Vendor;

@Repository
public interface VendorDao extends CrudRepository<Vendor, Integer> {

}
