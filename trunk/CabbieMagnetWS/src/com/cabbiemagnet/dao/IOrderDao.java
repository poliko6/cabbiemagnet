package com.cabbiemagnet.dao;

import java.util.ArrayList;

import com.cabbiemagnet.model.Order;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:34 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao	
 * @filename IOrderDao.java
 * @description 
 * ================================================================================
 */
public interface IOrderDao {
	
	void create(Order order);
	ArrayList<Order> read(long customerId);
	ArrayList<Order> readAll();
	void update(Order order);
	void delete(Order order);
	

}
