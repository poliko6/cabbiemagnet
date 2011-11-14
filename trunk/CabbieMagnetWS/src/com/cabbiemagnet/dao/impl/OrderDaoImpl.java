package com.cabbiemagnet.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cabbiemagnet.dao.IOrderDao;
import com.cabbiemagnet.dao.mapper.OrderRowMapper;
import com.cabbiemagnet.dao.mapper.OrderedCarRowMapper;
import com.cabbiemagnet.model.Order;
import com.cabbiemagnet.model.OrderedCar;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:54 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.impl	
 * @filename OrderDaoImpl.java
 * @description 
 * ================================================================================
 */
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

		String sqlGetOrder = " SELECT cab_order.id, "
				+ "customer.name as customer_name, "
				+ "company.name as company_name, "
				+ "cab_order_state.name as order_state, "
				+ "cab_order.time_ordered, "
				+ "cab_order.time_to_deliver as requested_time_to_deliver, "
				+ "cab_order.from_location, "
				+ "cab_order.to_location, "
				+ "cab_order.customer_note, "
				+ "cab_order_reply.time_to_deliver as order_reply_time_to_deliver, "
				+ "cab_order_reply.time_of_reply as order_reply_time, ( "
				+ "SELECT message.message	"
				+ "FROM cab_order_Reply "
				+ "JOIN Message ON message.id = cab_order_reply.message_id "
				+ "WHERE cab_order.id = cab_order_reply.cab_order_id ) AS order_reply_message "
				+ "FROM cab_order "
				+ "JOIN Customer ON customer.id = cab_order.customer_id "
				+ "JOIN Company ON company.id = cab_order.company_id "
				+ "JOIN cab_order_state ON cab_order_state.id = cab_order.state_id "
				+ "LEFT JOIN cab_order_reply ON cab_order.id = cab_order_reply.cab_order_id " 
				+ "WHERE customer.id = ? "
				+ "Order by cab_order.id";
		
		String sqlGetOrderedCars = "SELECT " +
				"car.type, " +
				"cab_order_has_cars.quantity, " +
				"cab_order_has_cars.cab_order_id " +
				"FROM cab_order_has_cars " +
				"JOIN car ON cab_order_has_cars.car_id = car.id " +
				"WHERE cab_order_has_cars.cab_order_id = ?";
		
		Object[] orderArgs = new Object[] { customerId };	// put the arguments for the query
		
		ArrayList<Order> orders = (ArrayList<Order>) this.jdbcTemplate.query(sqlGetOrder, orderArgs, new OrderRowMapper());	// query the db for all the orders for this customer
		
		// go through each order returned from the db
		for (int i = 0; i < orders.size(); i++)
		{
			Object[] carsArgs = new Object[] { orders.get(i).getId() };	// put the id of the first order in the arguments array
			ArrayList<OrderedCar> orderSpecificCars = (ArrayList<OrderedCar>) this.jdbcTemplate.query(sqlGetOrderedCars, carsArgs, new OrderedCarRowMapper());	// get the list of specific cars for each order
			
			orders.get(i).setCars(orderSpecificCars);	// add the list of order specific cars to each order.
		}
		
		// finally return all the orders 
		return orders;
	}

	@Override
	public ArrayList<Order> readAll() {

		String sqlGetOrder = " SELECT cab_order.id, "
				+ "customer.name as customer_name, "
				+ "company.name as company_name, "
				+ "cab_order_state.name as order_state, "
				+ "cab_order.time_ordered, "
				+ "cab_order.time_to_deliver as requested_time_to_deliver, "
				+ "cab_order.from_location, "
				+ "cab_order.to_location, "
				+ "cab_order.customer_note, "
				+ "cab_order_reply.time_to_deliver as order_reply_time_to_deliver, "
				+ "cab_order_reply.time_of_reply as order_reply_time, ( "
				+ "SELECT message.message	"
				+ "FROM cab_order_Reply "
				+ "JOIN Message ON message.id = cab_order_reply.message_id "
				+ "WHERE cab_order.id = cab_order_reply.cab_order_id ) AS order_reply_message "
				+ "FROM cab_order "
				+ "JOIN Customer ON customer.id = cab_order.customer_id "
				+ "JOIN Company ON company.id = cab_order.company_id "
				+ "JOIN cab_order_state ON cab_order_state.id = cab_order.state_id "
				+ "LEFT JOIN cab_order_reply ON cab_order.id = cab_order_reply.cab_order_id "
				+ "Order by cab_order.id";


		String sqlGetOrderedCars = "SELECT " +
				"car.type, " +
				"cab_order_has_cars.quantity, " +
				"cab_order_has_cars.cab_order_id " +
				"FROM cab_order_has_cars " +
				"JOIN car ON cab_order_has_cars.car_id = car.id ";

		ArrayList<Order> orders = (ArrayList<Order>) this.jdbcTemplate.query(
				sqlGetOrder, new OrderRowMapper());	// query the db for all the orders
		
		ArrayList<OrderedCar> orderedCars = (ArrayList<OrderedCar>) this.jdbcTemplate
				.query(sqlGetOrderedCars, new OrderedCarRowMapper()); // query the db for all the ordered cars

		
		// go through all the orders and find their ordered cars
		for (int i = 0; i < orders.size(); i++) {
			long id = orders.get(i).getId();	// get the id of the ordered
			
			ArrayList<OrderedCar> orderSpecificCars = new ArrayList<OrderedCar>(); 	// list of all the cars for the selected order with index (i)
			
			// then find the cars and set it to the order
			for (int j = 0; j < orderedCars.size(); j++) {
				
				// check if the car matched the order
				if (id == orderedCars.get(j).getOrderId()) {
					orderSpecificCars.add(orderedCars.get(j)); // add the car to
																// the list of
																// order
																// specific cars
				}
			}
			orders.get(i).setCars(orderSpecificCars); // add the list of cars to the order
		}

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
