package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cabbiemagnet.dao.IOrderDao;
import com.cabbiemagnet.model.Order;


@Path("/orders")
public class OrdersResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Order> getOrders() {

		IOrderDao ordersDao = (IOrderDao) Common.getContext().getBean("ordersDao"); // get compDao bean

		return ordersDao.readAll();
	}

}
