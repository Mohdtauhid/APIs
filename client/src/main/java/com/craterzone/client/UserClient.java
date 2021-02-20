package com.craterzone.client;

import com.craterzone.model.User;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserClient 
{
	@GET("/api/v1/users/{id}")
	Single<Response<User>> getUser(@Path(value = "id") int id);

}
