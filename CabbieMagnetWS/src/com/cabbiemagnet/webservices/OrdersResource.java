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
	
	IOrderDao ordersDao;
	
	public OrdersResource()
	{
		ordersDao = (IOrderDao) Common.getContext().getBean("ordersDao"); // get compDao bean
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Order> getOrders() {

				return ordersDao.readAll();
	}

}
