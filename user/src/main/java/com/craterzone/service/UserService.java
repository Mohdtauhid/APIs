package com.craterzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craterzone.exception.UserException;
import com.craterzone.gateway.UserGateway;
import com.craterzone.model.User;


@Service
public class UserService {

	@Autowired
	private UserGateway usergateway;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User getUser(int id) throws UserException 
	{
		User list = usergateway.getUser(id);
		return list;
	}
	
	
	
	/*	
	  public User getUserById(int userId) { 
		  return usergateway.findById(userId);
		  }
	 
	
	public List<User> getUser() {
		List<User> list=(List<User>)this.usergateway.findAll();
	return list;
	}


	public User add(User user) {
		 
		return usergateway.save(user);
	}


	public void deleteById(int userId) {
		usergateway.deleteById(userId);
	}
 

	public void update (int id ,User user) 
	{
	 user.setId(id);	
	 usergateway.save(user);
	}



	public void partialUpdate(int id, User user) {
		 user.setId(id);	
		 usergateway.save(user);
		
	}


*/
}


