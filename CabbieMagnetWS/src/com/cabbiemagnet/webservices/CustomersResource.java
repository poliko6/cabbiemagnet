package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cabbiemagnet.dao.ICustomerDao;
import com.cabbiemagnet.model.Customer;

@Path("/customers")
public class CustomersResource {
			
		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public ArrayList<Customer> getCustomers() {

			ICustomerDao custDao = (ICustomerDao) Common.getContext().getBean("custDao"); // get compDao bean

			return custDao.readAll();
		}
		
		@GET
		@Path("{id}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Customer getCustomer(@PathParam("id") long id)
		{
			ICustomerDao custDao = (ICustomerDao) Common.getContext().getBean("custDao"); // get compDao bean
			
			Customer customer = custDao.read(id);
			if (customer == null)
			{
				throw new RuntimeException("Customer with id " + id + " does not exist!");
			}
			return customer;
		}
		
		@POST
		@Path("{id}")
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes(MediaType.TEXT_PLAIN)
		public String PostShit(String id)
		{
			return "Hello, " + id;
		}
}
