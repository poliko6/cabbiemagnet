package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cabbiemagnet.model.Company;
import com.cabbiemagnet.dao.*;


// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /companies

@Path("/companies")
public class CompaniesResource { 

	// @Context
	// UriInfo uriInfo;
	// @Context
	// Request request;

	ApplicationContext context = new  FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompanies() {

		ICompanyDao compDao = (ICompanyDao) context.getBean("compDao"); // get compDao bean

		return compDao.selectAll();
	}

	@GET
	@Path("{location}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompaniesByLocation(
			@PathParam("location") String location) {

		ICompanyDao compDao = (ICompanyDao) context.getBean("compDao"); // get compDao bean
		
		return compDao.findByLocation(location);
	}
}