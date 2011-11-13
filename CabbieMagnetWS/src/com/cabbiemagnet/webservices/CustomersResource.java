package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cabbiemagnet.dao.ICustomerDao;
import com.cabbiemagnet.model.Customer;

@Path("/customers")
public class CustomersResource {
	private ICustomerDao custDao;

	public CustomersResource() {
		custDao = (ICustomerDao) Common.getContext().getBean("custDao");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Customer> getCustomers() {
		return custDao.readAll();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer getCustomer(@PathParam("id") long id) {
		
		Customer registeredCustomer = custDao.read(id); // check the db for this
														// customer

		if (registeredCustomer == null) // if the customer with id specified
										// does not exist
		{
			// create new customer
			Customer newCustomer = new Customer(); // create the customer
			newCustomer.setId(id);
			newCustomer.setName("User");
			custDao.create(newCustomer); // send it for creation
			return getCustomer(id); // return the created customer with another
									// check in the db
		}
		return registeredCustomer; // return customer's information
	}

//	@POST
//	@Path("{id}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Consumes(MediaType.TEXT_PLAIN)
//	public String PostShit(long id) {
//		return "Hello, " + id;
//	}
	
	@GET
	@Path("{id}/changename/{newName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer changeCustomerName(@PathParam("id") long id, @PathParam("newName") String newName)
	{
		Customer registeredCustomer = custDao.read(id); // check the db for this customer
		registeredCustomer.setName(newName);
		custDao.update(registeredCustomer);
		
		return registeredCustomer;
	}
	
}
