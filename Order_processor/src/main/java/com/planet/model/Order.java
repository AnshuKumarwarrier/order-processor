package com.planet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderprocessor")
public class Order {
	
	@Id
   
    private Long id;
    private String email;
    private String phoneNumber;
    private String parcel_weight;
    private String country;
    
    
    
    
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Order(Long id, String email, String phoneNumber, String parcel_weight, String country) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.parcel_weight = parcel_weight;
		this.country = country;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getParcel_weight() {
		return parcel_weight;
	}




	public void setParcel_weight(String parcel_weight) {
		this.parcel_weight = parcel_weight;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}


	
	
	
}