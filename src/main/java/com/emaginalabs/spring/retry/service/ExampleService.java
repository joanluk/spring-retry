package com.emaginalabs.spring.retry.service;

public interface ExampleService {

	String sendMail() throws Exception;
	
	int getTimes();
}
