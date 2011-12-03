package com.cabbiemagnet.webservices.customers;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cabbiemagnet.dao.ICustomerDao;
import com.cabbiemagnet.model.Customer;
import com.cabbiemagnet.webservices.Common;

/**
 * 
 * ============================================================================
 * ====
 * 
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:47:51 PM
 * 
 * @project CabbieMagnetWS
 * @package com.cabbiemagnet.webservices
 * @filename CustomersResource.java
 * @description 
 *              ==================================================================
 *              ==============
 */
@Path("/")
public class CustomersResource {
	private ICustomerDao custDao;

	@Context
	private UriInfo uriInfo;

	public CustomersResource() {
		custDao = (ICustomerDao) Common.getContext().getBean("custDao");
	}
	
	
	@PUT
	@Path("/change")
	public Response changeCustomerName(@QueryParam("id") long id,
			@DefaultValue ("User") @QueryParam("name") String newName) {
		Response res;

		if (newName.equals(" ")) { newName = "User"; }
		
		Customer registeredCustomer = custDao.read(id); // check the db for this
														// customer
		if (registeredCustomer == null) {
			res = Response.notModified().build();
		}
		// customer exists
		else {
			registeredCustomer.setName(newName);
			custDao.update(registeredCustomer);

			// response HTTP OK 200 and return the name in the body of the message
			res = Response.ok().entity(registeredCustomer.getName()).build();
		}

		return res;
	}

	@POST
	@Path("/new")
	public Response createCustomer(@QueryParam("id") long id, 
			@DefaultValue("User") @QueryParam ("name") String name) {
		
		Response res;

		if (custDao.read(id) == null) {
			// create new customer
			Customer newCustomer = new Customer(); // create the customer
			newCustomer.setId(id);
			newCustomer.setName(name);
			custDao.create(newCustomer); // send it for creation

			URI cUri = uriInfo.getAbsolutePathBuilder().build();
			
			// Response Created that give 
			res = Response.created(cUri).entity("Created user: " + id + " with name: " + name).build();
		} else {
			// no changes where made response 
			res = Response.notModified().build();
		}
		return res; // return customer's information
	}

	@GET
	@Path("{id}")
	//@Produces({ MediaType.APPLICATION_JSON })
	public Response getCustomer(@PathParam("id") long id) {

		Response res;

		// get customer from db
		Customer c = custDao.read(id);

		// check if customer exists
		if (c == null) {
			res = Response.noContent().build();
		} else {
			res = Response.ok(c.getName()).build();
		}
		return res; // return customer's name only text/plain
	}

	// get all the customer
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Customer> getCustomers() {
		return custDao.readAll();
	}

}
