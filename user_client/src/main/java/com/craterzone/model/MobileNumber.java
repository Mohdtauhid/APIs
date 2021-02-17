package com.craterzone.model;

import org.jetbrains.annotations.NotNull;

public class MobileNumber 
  {
  private int id;
  private String cc;
  private String number;
  
  public MobileNumber(@NotNull String cc, @NotNull String number) 
  {
	this.cc = cc;
	this.number = number;
  }
  public MobileNumber() 
	{
		super();
	}
  public String getCc() { 
	  return cc; }
  
  public void setCc(String cc) { 
	  this.cc = cc; }
  
  
  public String getNumber() { 
	  return number; 
	  }
  
  public void setNumber(String number) { 
	  this.number = number; 
	  }
  
  
  }
 
