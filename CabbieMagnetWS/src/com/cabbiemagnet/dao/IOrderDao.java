package com.cabbiemagnet.dao;

import java.util.ArrayList;

import com.cabbiemagnet.model.Order;

public interface IOrderDao {
	
	void create(Order order);
	ArrayList<Order> read(long customerId);
	ArrayList<Order> readAll();
	void update(Order order);
	void delete(Order order);
	

}
