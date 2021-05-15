package com.lopsmx.h2jpaweb.dao;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




/****NO ESTA 100% TERMINADO */

//@RunWith(SpringRunner.class)
@SpringBootTest
public class BillionaireDAOTests {
	
	private static final Logger log = LoggerFactory.getLogger(BillionaireDAOTests.class);

	
	@Autowired
	BillionaireDAO billionaireDAO; 
	
	@Test
	public void findAllBillionaries() {
		log.info("***** Find Billionaries *****");
//		Iterable<Billionaire> iterable = billionaireDAO.findAll();
		
		
		billionaireDAO.findAll().forEach(billionarie -> {
			log.info(billionarie.toString());
		});
	}

}
