package com.cabbiemagnet.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Order;


/**
 * rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 */
public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int line) throws SQLException {
		
		 Order order = new Order();
		order.setId(rs.getLong("ID"));
		order.setCompany(rs.getString("COMPANY_NAME"));
		order.setCustomer(rs.getString("CUSTOMER_NAME"));
		order.setState(rs.getString("ORDER_STATE"));
		order.setTimeOrdered(rs.getTimestamp("TIME_ORDERED"));
		order.setRequestedTimeToDeliver(rs.getTimestamp("REQUESTED_TIME_TO_DELIVER"));
		order.setFromLocation(rs.getString("FROM_LOCATION"));
		order.setToLocation(rs.getString("TO_LOCATION"));
		order.setCustomerNote(rs.getString("CUSTOMER_NOTE"));
		order.setOrderReply(rs.getString("ORDER_REPLY_MESSAGE"));
		order.setOrderReplyTime(rs.getTimestamp("ORDER_REPLY_TIME"));
		order.setOrderReplyTimeToDeliver(rs.getTimestamp("ORDER_REPLY_TIME_TO_DELIVER"));
		return order;
	}

}