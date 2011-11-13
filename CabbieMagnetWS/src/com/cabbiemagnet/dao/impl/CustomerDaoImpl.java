package com.cabbiemagnet.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

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
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void create(Customer customer) {

		String sql = "insert into customer ( id, name ) values ( ?, ?)";
		Object[] args = new Object[] { customer.getId(), customer.getName() };
		this.jdbcTemplate.update(sql, args);

	}

	@Override
	public Customer read(long id) {
		String sql = "SELECT * FROM Customer where id =?";
		Object[] args = new Object[] { id};
		ArrayList<Customer> customers = (ArrayList<Customer>) this.jdbcTemplate.query(sql,args, new CustomerRowMapper());

		if (customers.size() == 0)
		{
			return null;
		}
		return customers.get(0);
	}

	@Override
	public void update(Customer customer) {
		String sql = "update customer set name = ? where id = ?";
		Object[] args = new Object[] { customer.getName(), customer.getId() };
		this.jdbcTemplate.update(sql, args);

	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Customer> readAll() {
		
		String sql = "SELECT * FROM Customer";
		
		return (ArrayList<Customer>) jdbcTemplate.query(sql, new CustomerRowMapper());
		
	}

}
