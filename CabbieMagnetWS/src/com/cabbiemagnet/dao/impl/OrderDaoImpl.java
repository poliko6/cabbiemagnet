package com.cabbiemagnet.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cabbiemagnet.dao.IOrderDao;
import com.cabbiemagnet.dao.mapper.OrderRowMapper;
import com.cabbiemagnet.model.Order;

public class OrderDaoImpl implements IOrderDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void create(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Order> read(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> readAll() {

		String sql = " SELECT cab_order.id, " +
				"customer.name as customer_name, " +
				"company.name as company_name, " +
				"cab_order_state.name as order_state, " +
				"cab_order.time_ordered, " +
				"cab_order.time_to_deliver as requested_time_to_deliver, " +
				"cab_order.from_location, " +
				"cab_order.to_location, " +
				"cab_order.customer_note, " +
				"cab_order_reply.time_to_deliver as order_reply_time_to_deliver, " +
				"cab_order_reply.time_of_reply as order_reply_time, ( " +
				"SELECT message.message	" +
				"FROM cab_order_Reply " +
				"JOIN Message ON message.id = cab_order_reply.message_id " +
				"WHERE cab_order.id = cab_order_reply.cab_order_id ) AS order_reply_message " +
				"FROM cab_order " +
				"JOIN Customer ON customer.id = cab_order.customer_id " +
				"JOIN Company ON company.id = cab_order.company_id " +
				"JOIN cab_order_state ON cab_order_state.id = cab_order.state_id " +
				"JOIN cab_order_reply ON cab_order.id = cab_order_reply.cab_order_id " +
				"Order by cab_order.id";
		
		ArrayList<Order> orders = (ArrayList<Order>) this.jdbcTemplate.query(sql, new OrderRowMapper());
		
		
		return orders;
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub

	}

}
