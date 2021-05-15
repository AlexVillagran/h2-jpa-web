package com.lopsmx.h2jpaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lopsmx.h2jpaweb.service.BillionaireService;

@Controller
public class MainController {
		
	@Autowired
	private BillionaireService billionaireService;
	
	
	
	@RequestMapping("/billionaires")
	public ModelAndView billionaires() {
		ModelAndView modelAndView = new ModelAndView("billionaires");
		
		//Revisar si se puede evitar el string
		modelAndView.addObject("billionaires", billionaireService.findAll());
		
		
		return modelAndView;
	}
}
