package com.cabbiemagnet.dao;

import java.util.ArrayList;

import com.cabbiemagnet.model.Customer;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:27 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao	
 * @filename ICustomerDao.java
 * @description 
 * ================================================================================
 */
public interface ICustomerDao {
	
	void create(Customer customer);
	void delete(Customer customer);
	Customer read(long id);
	ArrayList<Customer> readAll();
	
	void update(Customer customer);

	

}
