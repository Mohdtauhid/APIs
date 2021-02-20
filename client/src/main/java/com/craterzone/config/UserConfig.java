package com.craterzone.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craterzone.client.UserClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
@Configuration
public class UserConfig 
{
@Bean
public UserClient masterClient(@Value("${connection.read.timeout.second}") final Long timeoutSeconds, @Value("${master.base.url}") final String baseUrl) 
{
		 return new Retrofit.Builder()
		.client(new OkHttpClient.Builder().readTimeout(timeoutSeconds, TimeUnit.SECONDS)
		.connectTimeout(timeoutSeconds, TimeUnit.SECONDS)
		.addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BASIC)).build())
	    .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()) 													//converts java objects to their JSON
		//.baseUrl(baseUrl).addConverterFactory(JacksonConverterFactory.create(buildDefaultMapper()))       						  //converts java objects to their JSON
		.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(UserClient.class);
}

/*
private ObjectMapper buildDefaultMapper() 
{
	final ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.registerModule(new JavaTimeModule());
	objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	return objectMapper;
}
*/

}
