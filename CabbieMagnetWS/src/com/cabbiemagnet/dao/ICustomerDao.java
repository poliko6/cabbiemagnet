package com.cabbiemagnet.dao;

import java.util.ArrayList;

import com.cabbiemagnet.model.Customer;

public interface ICustomerDao {
	
	void create(Customer customer);
	Customer read(long id);
	void update(Customer customer);
	void delete(Customer customer);
	
	ArrayList<Customer> readAll();

	

}
