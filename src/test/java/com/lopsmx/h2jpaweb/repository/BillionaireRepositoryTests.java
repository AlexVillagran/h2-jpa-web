package com.lopsmx.h2jpaweb.repository;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lopsmx.h2jpaweb.repository.BillionaireRepository;

@SpringBootTest
public class BillionaireRepositoryTests {
	
	private static final Logger log = LoggerFactory.getLogger(BillionaireRepositoryTests.class);
	
	@Autowired
	BillionaireRepository billionaireDAO; 
	
	@Test
	public void findAllBillionaries() {
		
		log.info("***** Find Billionaries *****");		
		
		billionaireDAO.findAll().forEach(billionarie -> {
			log.info(billionarie.toString());
		});
	}

}
