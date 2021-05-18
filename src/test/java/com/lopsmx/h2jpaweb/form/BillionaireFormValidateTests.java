package com.lopsmx.h2jpaweb.form;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BillionaireFormValidateTests {
	private static Logger logger=LoggerFactory.getLogger(BillionaireFormValidateTests.class); 
	private static Validator validator;	
	
    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        
    }
    
    @Test
    public void lastNameNull() {
    	logger.info("****** Validation LastName null  ******");
    	
    	BillionaireForm billionaireForm = new BillionaireForm("Jhony", null, "Wisky");
    	
    	Set<ConstraintViolation<BillionaireForm>> constraintViolations =
    			validator.validate(billionaireForm);
    	
    	constraintViolations.forEach(constraintViolation -> {
    		logger.info(constraintViolation.getMessage());
    	});
    	
    	assertThat(constraintViolations.size()).isEqualTo(1);   	

    }
    
    @Test
    public void lastNameEmpty() {
    	logger.info("****** Validation LastName Empty  ******");
    	
    	BillionaireForm billionaireForm = new BillionaireForm("Jhony", "", "Wisky");
    	
    	Set<ConstraintViolation<BillionaireForm>> constraintViolations =
    			validator.validate(billionaireForm);
    	
    	constraintViolations.forEach(constraintViolation -> {
    		logger.info(constraintViolation.getMessage());
    	});
    	
    	assertThat(constraintViolations.size()).isEqualTo(1);   	

    }
    
    @Test
    public void lastNameSpacingWhite() {
    	logger.info("****** Validation LastName Spacing White  ******");
    	
    	BillionaireForm billionaireForm = new BillionaireForm("Jhony", "  ", "Wisky");
    	
    	Set<ConstraintViolation<BillionaireForm>> constraintViolations =
    			validator.validate(billionaireForm);
    	
    	constraintViolations.forEach(constraintViolation -> {
    		logger.info(constraintViolation.getMessage());
    	});
    	
    	assertThat(constraintViolations.size()).isEqualTo(1);   	

    }
    
    @Test
    public void lastNameExists() {
    	logger.info("****** Validation LastName Exists  ******");
    	
    	BillionaireForm billionaireForm = new BillionaireForm("Jhony", "Alakija", "Wisky");
    	
    	Set<ConstraintViolation<BillionaireForm>> constraintViolations =
    			validator.validate(billionaireForm);
    	
    	constraintViolations.forEach(constraintViolation -> {
    		logger.info(constraintViolation.getMessage());
    	});
    	
    	assertThat(constraintViolations.size()).isEqualTo(1);   	

    }
    
    
}
