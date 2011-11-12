package com.cabbiemagnet.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cabbiemagnet.dao.ICustomerDao;
import com.cabbiemagnet.dao.mapper.CustomerRowMapper;
import com.cabbiemagnet.model.Customer;

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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
