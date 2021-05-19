package com.lopsmx.h2jpaweb.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillionaireControllerIntegrationTests {
	
	private static final Logger log = LoggerFactory.getLogger(BillionaireControllerIntegrationTests.class);


	@Autowired
	private MockMvc mockMvc;	
	
	@Test
	public void loadPageListBillionaires() throws Exception {
		log.info("********** List Billionaires  **********");		
		
		mockMvc.perform(get("/billionaires"))
			.andExpect(status().isOk())
			.andExpect(view().name("billionaires"))
			.andDo(print());
	}
	
	@Test
	public void loadFormPageBillionaires() throws Exception {
		log.info("********** Load Form Page Billionaire  **********");		
		
		mockMvc.perform(get("/billionaire"))
			.andExpect(status().isOk())
			.andExpect(view().name("billionaire"))
			.andDo(print());
	}
	
	@Test
	public void submitFormPageWhithErrorBillionairesFieldsEmpty() throws Exception {
		log.info("********** Submit Form  With Error Page Billionaire FieldsEmpty **********");		
		
		mockMvc.perform(
				post("/billionaire")
				.param("firstName", "  ")
				.param("lastName", "")
				.param("career", "")
			)
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(model().errorCount(3))
			.andExpect(view().name("billionaire"))
			.andDo(print());
	}
	
	@Test
	public void submitFormPageWhithErrorBillionairesDuplicate() throws Exception {
		log.info("********** Submit Form  With Error  Page Billionaire Duplicate **********");		
		
		mockMvc.perform(
				post("/billionaire")
				.param("firstName", "Jhon")
				.param("lastName", "Alakija")
				.param("career", "Amazon Online")
			)
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(model().errorCount(1))
			.andExpect(view().name("billionaire"))
			.andDo(print());
	}
	@Test
	public void submitFormPageWithOutErrorBillionaires() throws Exception {
		log.info("********** Submit Form  With Out Page Billionaire  **********");		
		
		mockMvc.perform(
				post("/billionaire")
				.param("firstName", "Jeff")
				.param("lastName", "Bezos")
				.param("career", "Amazon Online")
			)
			.andExpect(status().isOk())
			.andExpect(model().hasNoErrors())
			.andExpect(model().attributeExists("billionaires"))
			.andExpect(view().name("billionaires"))
			.andDo(print());
	}
	
}
