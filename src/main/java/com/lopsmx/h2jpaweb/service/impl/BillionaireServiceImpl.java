package com.lopsmx.h2jpaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopsmx.h2jpaweb.dao.BillionaireDAO;
import com.lopsmx.h2jpaweb.entity.Billionaire;
import com.lopsmx.h2jpaweb.service.BillionaireService;

@Service
public class BillionaireServiceImpl implements BillionaireService{

	@Autowired
	private BillionaireDAO billionaireRepository;
	@Override
	public Iterable<Billionaire> findAll() {
		
		return billionaireRepository.findAll();
	}

}
