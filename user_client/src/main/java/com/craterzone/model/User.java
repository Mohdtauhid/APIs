package com.craterzone.model;


public class User 
{
	private int id;
	private String name;
	private String email;
	private MobileNumber mobileNumber;
  	private Address address;

	public User(int id, String name,String email,MobileNumber mobileNumber,Address address) 
	{	
		this.id = id;
		this.name = name;
		this.email=email;
		this.mobileNumber=mobileNumber;
		this.address=address;
	}

	public User()
	{
		super();	 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MobileNumber getMobileNumber( ) {
		return mobileNumber ;
	}

	public void setMobileNumber(MobileNumber mobileNumber) {
		 this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		 this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}


}


