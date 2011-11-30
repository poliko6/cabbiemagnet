package com.cabbiemagnet.dao.impl;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cabbiemagnet.dao.ICustomerDao;
import com.cabbiemagnet.dao.mapper.CustomerRowMapper;
import com.cabbiemagnet.model.Customer;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:47 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.impl	
 * @filename CustomerDaoImpl.java
 * @description 
 * ================================================================================
 */
public class CustomerDaoImpl implements ICustomerDao {

	private JdbcTemplate jdbcTemplate;
	private static Log logger = LogFactory.getLog(CustomerDaoImpl.class);

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (ID, NAME) VALUES ( ?, ?);";
		Object[] args = new Object[] { customer.getId(), customer.getName() };
		this.jdbcTemplate.update(sql, args);
		logger.info("Inserted a new customer: " + customer.getId());
	}

	@Override
	public Customer read(long id) {
		String sql = "SELECT * FROM CUSTOMER WHERE ID =?";
		Object[] args = new Object[] { id};
		ArrayList<Customer> customers = (ArrayList<Customer>) this.jdbcTemplate.query(sql,args, new CustomerRowMapper());

		if (customers.size() == 0)
		{
			return null;
		}
		return customers.get(0);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Customer customer) {
		String sql = "UPDATE CUSTOMER SET NAME = ? WHERE ID = ?";
		Object[] args = new Object[] { customer.getName(), customer.getId() };
		this.jdbcTemplate.update(sql, args);
		logger.info("Customer: " + customer.getId() + " updated name to: " + customer.getName() );

	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Customer> readAll() {
		
		String sql = "SELECT * FROM CUSTOMER";
		
		return (ArrayList<Customer>) jdbcTemplate.query(sql, new CustomerRowMapper());
		
	}

}
