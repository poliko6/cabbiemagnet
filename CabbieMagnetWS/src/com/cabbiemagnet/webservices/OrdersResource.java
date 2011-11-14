package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cabbiemagnet.dao.IOrderDao;
import com.cabbiemagnet.model.Order;

/**
  * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:47:57 PM
 * 
 * @project CabbieMagnetWS
 * @package com.cabbiemagnet.webservices
 * @filename OrdersResource.java
 * @description 
 */
@Path("/orders")
public class OrdersResource {

	IOrderDao ordersDao;

	public OrdersResource() {
		ordersDao = (IOrderDao) Common.getContext().getBean("ordersDao"); // get
																			// compDao
																			// bean
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Order> getOrders() {

		return ordersDao.readAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("customer/{id}")
	public ArrayList<Order> getOrdersByCustomer(@PathParam("id") long id) {

		return ordersDao.read(id);
	}

}
