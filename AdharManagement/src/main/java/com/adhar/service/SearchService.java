package com.adhar.service;

import com.adhar.bean.Customer;

public class SearchService {

	public static Customer getAadharSerachResult(String aadharNumber) {
		
		//call to DAO and get the Customer information
		Customer customer = new Customer();
		customer.setAadharNumber("123456789");
		customer.setFirstName("Hari");
		customer.setLastName("Krishna");
		customer.setDob("01-Jan-1990");
		customer.setGender("Male");
		
		return customer;
	}

}
