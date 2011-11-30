package com.cabbiemagnet.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Order;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:45:42 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.mapper	
 * @filename OrderRowMapper.java
 * @description rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 * ================================================================================
 */
public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int line) throws SQLException {
		
		 Order order = new Order();
		order.setId(rs.getLong("ID"));
		order.setCompanyId(rs.getLong("COMPANY_ID"));
		order.setCompany(rs.getString("COMPANY_NAME"));
		order.setCustomerId(rs.getLong("CUSTOMER_ID"));
		order.setCustomer(rs.getString("CUSTOMER_NAME"));
		order.setState(rs.getString("ORDER_STATE"));
		order.setTimeOrdered(rs.getTimestamp("TIME_ORDERED"));
		order.setRequestedTimeToDeliver(rs.getTimestamp("REQUESTED_TIME_TO_DELIVER"));
		order.setFromLocation(rs.getString("FROM_LOCATION"));
		order.setToLocation(rs.getString("TO_LOCATION"));
		order.setCustomerNote(rs.getString("CUSTOMER_NOTE"));
		order.setOrderReplyMessage(rs.getString("ORDER_REPLY_MESSAGE"));
		order.setOrderReplyTime(rs.getTimestamp("ORDER_REPLY_TIME"));
		order.setOrderReplyTimeToDeliver(rs.getTimestamp("ORDER_REPLY_TIME_TO_DELIVER"));
		return order;
	}

}