package com.lopsmx.h2jpaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lopsmx.h2jpaweb.form.BillionaireForm;
import com.lopsmx.h2jpaweb.service.BillionaireService;

@Controller
public class MainController {
		
	@Autowired
	private BillionaireService billionaireService;	
	
	@GetMapping("/billionaires")
	public ModelAndView loadPageListBillionaires() {
		ModelAndView modelAndView = new ModelAndView("billionaires");
		
		//Revisar si se puede evitar el string
		modelAndView.addObject("billionaires", billionaireService.findAll());
		
		
		return modelAndView;
	}
	
	@GetMapping("/billionaire")
	public String loadFormPage(Model model) {
		model.addAttribute("billionaireForm", new BillionaireForm());
		
		return "billionaire";
	}
	
	@PostMapping("/billionaire")
	public String submitForm(BillionaireForm billionaireForm, Model  model) {
		
		
		return "billionaires";
	}
	
}
