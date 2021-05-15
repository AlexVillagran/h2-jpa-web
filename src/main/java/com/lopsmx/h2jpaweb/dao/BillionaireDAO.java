package com.lopsmx.h2jpaweb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lopsmx.h2jpaweb.entity.Billionaire;

public interface BillionaireDAO extends CrudRepository<Billionaire, Long> {
	List<Billionaire> findByLastName(String lastName);
	Billionaire findById(long id);
	
}
