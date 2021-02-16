package com.craterzone.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craterzone.model.User;
import com.craterzone.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController 
{
	@Autowired
	private  UserService userService;
	
	
	public UserController(final UserService userService){
		this.userService = userService;	 
	}
	
	  @GetMapping("/{id}") 
	  public ResponseEntity<User> getUser(@PathVariable("id") int id) { 
		User user = userService.getUserById(id); 
		if(Objects.nonNull(user)) 
		{
	    return ResponseEntity.status(HttpStatus.OK).body(user); 
	  } 
		return ResponseEntity.badRequest().build(); }
	 
	
	  @GetMapping
	  public ResponseEntity<List<User>> getAllUser(){
		 List<User> list=  userService.getUser();
		 if(list.size()<=0)
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 else
			 return ResponseEntity.of(Optional.of(list));
	  }
	  
	  @PostMapping
	  public void addUser(@RequestBody User user){
		   userService.add(user);
	  }
	  
	  @PutMapping("/{id}")                                                            //Full update
	  public void updateUser(@PathVariable("id") int id, @RequestBody User user){
	     userService.update(id,user);
	 
	  }
	  
	  @PatchMapping("/{id}")														//Partial update
	  public void parialUpdateUser(@PathVariable("id") int id, @RequestBody User user){
	     userService.partialUpdate(id,user);
	 
	  }
	  @DeleteMapping("/{id}")
	  public void deleteUserById(@PathVariable("id") int id){
	         userService.deleteById(id);
	    }
	 
	  
}
