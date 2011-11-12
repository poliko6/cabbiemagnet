package com.cabbiemagnet.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.cabbiemagnet.model.OrderedCar;

/**
 * rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 */
public class OrderedCarRowMapper implements RowMapper<OrderedCar> {

	@Override
	public OrderedCar mapRow(ResultSet rs, int line) throws SQLException {
		
		OrderedCar car = new OrderedCar();
		car.setOrderId(rs.getLong("CAB_ORDER_ID"));
		car.setType(rs.getString("TYPE"));
		car.setQuantity(rs.getInt("QUANTITY"));
		return car;
	}

}