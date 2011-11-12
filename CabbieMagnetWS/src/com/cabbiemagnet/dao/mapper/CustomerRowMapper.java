package com.cabbiemagnet.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Customer;

/**
 * rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 */
public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int line) throws SQLException {
		
		Customer customer = new Customer();
		customer.setId(rs.getLong("ID"));
		customer.setName(rs.getString("NAME"));
		return customer;
	}

}
