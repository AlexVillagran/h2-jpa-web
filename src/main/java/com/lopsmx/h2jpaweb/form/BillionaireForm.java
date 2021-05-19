package com.lopsmx.h2jpaweb.form;

import javax.validation.constraints.NotBlank;

import com.lopsmx.h2jpaweb.form.validate.LastNameConstraint;

public class BillionaireForm {
	private Long id;
	
	@NotBlank
	private String firstName;	
	@LastNameConstraint
	private String lastName;
	@NotBlank
	private String career;	
	
	public BillionaireForm() {}
	
	public BillionaireForm(String firstName, String lastName, String career) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.career = career;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	
	
}
