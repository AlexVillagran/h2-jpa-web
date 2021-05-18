package com.lopsmx.h2jpaweb.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lopsmx.h2jpaweb.model.Billionaire;

@RunWith(SpringRunner.class)
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
	
	@Test
	public void findByLastNameBillionarieExists() {
		
		log.info("***** Find Billionarie LastName *****");
		
		List<Billionaire> billionaries = billionaireDAO.findByLastName("Alakija");
		
		assertThat(billionaries.size()).isEqualTo(1);
		assertThat(billionaries.get(0).getFirstName()).isEqualTo("Folrunsho");
		assertThat(billionaries.get(0).getLastName()).isEqualTo("Alakija");
		assertThat(billionaries.get(0).getCareer()).isEqualTo("Billionaire Oil Magnate");		
		
	}
	
	@Test
	public void findByLastNameBillionarieNotExists() {
		
		log.info("***** Find Billionarie LastName Not Exists *****");
		
		List<Billionaire> billionaries = billionaireDAO.findByLastName("Walker");
		
		assertThat(billionaries.size()).isEqualTo(0);
		
	}

}
