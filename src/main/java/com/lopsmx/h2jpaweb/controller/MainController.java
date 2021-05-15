package com.lopsmx.h2jpaweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lopsmx.h2jpaweb.entity.Billionaire;
import com.lopsmx.h2jpaweb.service.BillionaireService;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	
	@Autowired
	private BillionaireService billionaireService;
	
	
	
	@RequestMapping("/billionaires")
	public ModelAndView billionaires() {
		ModelAndView modelAndView = new ModelAndView("billionaires");
		Iterable<Billionaire> billionaries = billionaireService.findAll();		
		
		//Revisar si se puede evitar el string
		modelAndView.addObject("billionaries", billionaries);
		
		
		return modelAndView;
	}
}
