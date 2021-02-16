package com.craterzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address") 
public class Address {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
		private int id;
@Column
private String city;

@Column 
private String state;

@Column 
private String country;

public Address(String city, String state, String country) { 
	  this.city = city;
    this.state = state; 
    this.country = country; }

public String getCity() { 
	  return city; }

public void setCity(String city) {
	  this.city = city; }

public String getState() { 
	  return state; }

public void setState(String state) { 
	  this.state = state; }

public String getCountry() { 
	  return country; }

public void setCountry(String country) { 
	  this.country = country; }

public Address() {
	super();

}


}

