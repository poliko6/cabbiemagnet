package com.cabbiemagnet.webservices.orders;

import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cabbiemagnet.dao.IOrderDao;
import com.cabbiemagnet.model.Order;
import com.cabbiemagnet.model.OrderedCar;
import com.cabbiemagnet.webservices.Common;

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
@Path("/")
public class OrdersResource {

	IOrderDao ordersDao;

	@Context
	private UriInfo uriInfo;


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
		//return the orders for the specific customer
		return ordersDao.read(id);
	}

	// create a new order from the given information
	// can read only 1 car
	@POST
	@Path("/new")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createNewOrder(ArrayList<OrderedCar> cars,
			@QueryParam("customer_id") long customerId,
			@QueryParam("company_id") long companyId,
			@QueryParam("time_to_deliver") Timestamp timeToDeliver,
			@QueryParam("from_loc") String from_loc,
			@QueryParam("to_loc") String to_loc,
			@QueryParam("customer_note") String customerNote) {
		
		// if no cars were specified return noContent response
		if (cars == null) {
			return Response.noContent().entity("No cars were specified!").build();
		}
		
		System.out.println("cars size: " + cars.size());

		// create an order from the query
		Order order = new Order();
		order.setCompanyId(companyId);
		order.setCustomerId(customerId);
		order.setRequestedTimeToDeliver(timeToDeliver);
		order.setFromLocation(from_loc);
		order.setToLocation(to_loc);
		order.setCustomerNote(customerNote);
		order.setCars(cars);

		// post the order to the db
		ordersDao.create(order);
		URI orderUri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(orderUri).build();
	}

//	@POST
//	@Path("/test")
//	@Consumes({ MediaType.APPLICATION_JSON })
//	public void test(OrderedCar[] cars) {
//
//		System.out.println(cars.length);
//		// System.out.println(cars.get(0).toString());
//		// System.out.println(cars.get(1).toString());
//		// URI orderUri = uriInfo.getAbsolutePathBuilder().
//		// path(s.getValue().get(0).toString()).
//		// build();
//		// return Response.created(orderUri).build();
//	}

}
