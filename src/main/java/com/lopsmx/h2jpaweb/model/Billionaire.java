package com.lopsmx.h2jpaweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "billionaires")
@Entity
public class Billionaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String career;
	
	
	
	public Billionaire() {}
	public Billionaire(String firstName, String lastName, String career) {
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
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "Billionaire [id=" + id + 
							", firstName=" + firstName + 
							", lastName=" + lastName + 
							", career=" + career
				+ "]";
	}
	
	

}
