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
		.baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
		//.addConverterFactory(ScalarsConverterFactory.create())
		.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(UserClient.class);
}


}
