package com.lopsmx.h2jpaweb.form.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lopsmx.h2jpaweb.service.BillionaireService;


public class LastNameValidator implements ConstraintValidator<LastNameConstraint, String>{	
	
	@Autowired
	private BillionaireService billionaireService;

	@Override
	public boolean isValid(String lastName, ConstraintValidatorContext context) {
		
		context.disableDefaultConstraintViolation();
		
		if (lastName == null || lastName.trim().isEmpty()) {			
			context.buildConstraintViolationWithTemplate("Insert last name !!")
			.addConstraintViolation();
			return false;
			
		} else if(billionaireService.findByLastName(lastName ).size() > 0 ) {		
			context.buildConstraintViolationWithTemplate("Last name exists!!")
				.addConstraintViolation();
			return false;			
			
		}else {
			return true;
		}		
		
	}

}
