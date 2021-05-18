package com.lopsmx.h2jpaweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lopsmx.h2jpaweb.model.Billionaire;

public interface BillionaireRepository extends CrudRepository<Billionaire, Long> {
	List<Billionaire> findByLastName(String lastName);
	Billionaire findById(long id);
	
	
}
