package com.cabbiemagnet.webservices.companies;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cabbiemagnet.model.Company;
import com.cabbiemagnet.webservices.Common;
import com.cabbiemagnet.dao.*;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:47:42 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.webservices	
 * @filename CompaniesResource.java
 * @description 
 * ================================================================================
 */
@Path("/")
public class CompaniesResource {

	// @Context
	// UriInfo uriInfo;
	// @Context
	// Request request;

//	ApplicationContext context;

	ICompanyDao compDao;
	
	// default constructor that gets the DAO bean
	public CompaniesResource()
	{
		compDao = (ICompanyDao) Common.getContext().getBean("compDao");
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompanies() {

		ArrayList<Company> companies = compDao.readAll();	// retrieve companies

		// throw runtime exception with information if no companies were found
		if (companies.size() == 0) {
			throw new RuntimeException("No companies found!");
		}

		return companies;
	}

	@GET
	@Path("{location}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompaniesByLocation(
			@PathParam("location") String location) {
		
		ArrayList<Company> companies = compDao.findByLocation(location);	// retrieve companies
		
		// throw runtime exception with information if no companies were found
		if (companies.size() == 0) {
			throw new RuntimeException("No companies found from " + location + "!");
		}

		return companies;
	}
}