package com.lopsmx.h2jpaweb.service;

import java.util.List;

import com.lopsmx.h2jpaweb.model.Billionaire;

public interface BillionaireService {
	public   Iterable <Billionaire> findAll();
	List<Billionaire> findByLastName(String lastName);
	public void add(Billionaire billionaire);
}
