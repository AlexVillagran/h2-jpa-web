package com.lopsmx.h2jpaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopsmx.h2jpaweb.model.Billionaire;
import com.lopsmx.h2jpaweb.repository.BillionaireRepository;
import com.lopsmx.h2jpaweb.service.BillionaireService;

@Service
public class BillionaireServiceImpl implements BillionaireService{

	@Autowired
	private BillionaireRepository billionaireRepository;
	@Override
	public Iterable<Billionaire> findAll() {
		
		return billionaireRepository.findAll();
	}
	@Override
	public List<Billionaire> findByLastName(String lastName) {
		return billionaireRepository.findByLastName(lastName);
	}

}
