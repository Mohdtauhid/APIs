package com.craterzone.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.craterzone.client.UserClient;
import com.craterzone.exception.UserException;
import com.craterzone.model.User;

import retrofit2.Response;

@Component
public class UserGateway 
{
//private static final Logger logger = LoggerFactory.getLogger(UserGateway.class);
@Autowired
private UserClient masterClient;

public User getUser(int id) throws UserException 
{
  Response<User> userResponse = masterClient.getUser(id).blockingGet();
  
	if (userResponse.code() == HttpStatus.NO_CONTENT.value())
		throw new UserException("USER_NOT_FOUND", HttpStatus.BAD_REQUEST);

	if (!userResponse.isSuccessful()) 
		throw new UserException("USER_NOT_FOUND", HttpStatus.BAD_REQUEST);
						//logger.info("Hello World");
return userResponse.body();
 
}

/*	
userResponse.body().getConfiguration().setPmsPassword(this.decrypt(userResponse.body().getConfiguration().getPmsPassword()));
userResponse.body().getConfiguration().setSmtpPassword(this.decrypt(userResponse.body().getConfiguration().getSmtpPassword()));
userResponse.body().getDbConnection().setUrl(this.decrypt(userResponse.body().getDbConnection().getUrl()));
userResponse.body().getDbConnection().setPassword(this.decrypt(userResponse.body().getDbConnection().getPassword()));
userResponse.body().getDbConnection().setUserName(this.decrypt(userResponse.body().getDbConnection().getUserName()));
return UserResponse.body();
*/
	
}