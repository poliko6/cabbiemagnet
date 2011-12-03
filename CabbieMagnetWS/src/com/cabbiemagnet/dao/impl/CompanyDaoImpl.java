package com.cabbiemagnet.dao.impl;


import org.springframework.jdbc.core.JdbcTemplate;

import com.cabbiemagnet.model.*;

import java.sql.Types;
import java.util.ArrayList;

import com.cabbiemagnet.dao.ICompanyDao;
import com.cabbiemagnet.dao.mapper.*;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:41 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.impl	
 * @filename CompanyDaoImpl.java
 * @description 
 * ================================================================================
 */
public class CompanyDaoImpl implements ICompanyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void delete(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Company> findByLocation(String location) {
		ArrayList<Company> companies = new ArrayList<Company>();
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Service> services = new ArrayList<Service>();

		
		String sqlCars = "SELECT CAR.ID, CAR.type, CAR.max_seats, CAR.max_handicapped_seats, CAR.max_hold_bags " +
				"FROM COMPANY_HAS_CARS " +
				"JOIN COMPANY ON COMPANY.ID = COMPANY_HAS_CARS.company_id " +
				"JOIN CAR ON CAR.id = COMPANY_HAS_CARS.CAR_ID " +
				"WHERE COMPANY_HAS_CARS.company_id = ?";
		
		String sqlServices = "select SERVICE.id, SERVICE.name " +
				"from CAR_HAS_SERVICES " +
				"JOIN SERVICE ON " +
				"SERVICE.id = CAR_HAS_SERVICES.service_id " +
				"JOIN CAR ON " +
				"CAR.id = CAR_HAS_SERVICES.car_id " +
				"where CAR_HAS_SERVICES.car_id = ?";
		
		String sqlCompanies = "select * from COMPANY WHERE LOCATION LIKE ?";
		
		// get all the companies
		Object[] compArgs = new Object[] { location };
		companies = (ArrayList<Company>) jdbcTemplate.query(sqlCompanies, compArgs, new CompanyRowMapper());
		
		for (int i = 0; i < companies.size(); i++)
		{
			
			Object [] compIds = new Object[] { companies.get(i).getId() }; 	// get company id as argument
			cars = (ArrayList<Car>) jdbcTemplate.query(sqlCars, compIds, new CarRowMapper()); 	// query the db for all the cars the company has
			
			for (int j = 0; j < cars.size(); j++)
			{
				Object [] carIds = new Object[] { cars.get(j).getId() };	// get id of the car to find services
				services = (ArrayList<Service>) jdbcTemplate.query(sqlServices, carIds, new ServiceRowMapper()); // get the services list from db
				
				cars.get(j).setServices(services); // set the services for every car
				
			}
		
			// set list of cars to the specific company
			companies.get(i).setCars(cars); 
		}

		
		return companies;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public ArrayList<Company> readAll() {
		ArrayList<Company> companies = new ArrayList<Company>();
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Service> services = new ArrayList<Service>();

		
		String sqlCars = "SELECT CAR.ID, CAR.type, CAR.max_seats, CAR.max_handicapped_seats, CAR.max_hold_bags " +
				"FROM COMPANY_HAS_CARS " +
				"JOIN COMPANY ON COMPANY.ID = COMPANY_HAS_CARS.company_id " +
				"JOIN CAR ON CAR.id = COMPANY_HAS_CARS.CAR_ID " +
				"WHERE COMPANY_HAS_CARS.company_id = ?";
		
		String sqlServices = "select SERVICE.id, SERVICE.name " +
				"from CAR_HAS_SERVICES " +
				"JOIN SERVICE ON " +
				"SERVICE.id = CAR_HAS_SERVICES.service_id " +
				"JOIN CAR ON " +
				"CAR.id = CAR_HAS_SERVICES.car_id " +
				"where CAR_HAS_SERVICES.car_id = ?";
		
		// get all the companies
		companies = (ArrayList<Company>) jdbcTemplate.query("select * from COMPANY", new CompanyRowMapper());
		
		for (int i = 0; i < companies.size(); i++)
		{
			
			Object [] compIds = new Object[] { companies.get(i).getId() }; 	// get company id as argument
			cars = (ArrayList<Car>) jdbcTemplate.query(sqlCars, compIds, new CarRowMapper()); 	// query the db for all the cars the company has
			
			for (int j = 0; j < cars.size(); j++)
			{
				Object [] carIds = new Object[] { cars.get(j).getId() };	// get id of the car to find services
				services = (ArrayList<Service>) jdbcTemplate.query(sqlServices, carIds, new ServiceRowMapper()); // get the services list from db
				
				cars.get(j).setServices(services); // set the services for every car
				
			}
		
			// set list of cars to the specific company
			companies.get(i).setCars(cars); 
		}

		
		return companies;
	}

	@Override
	public void save(Company company) {

		String sql = "INSERT INTO COMPANIES (NAME, LOCATION) VALUES(?,?)";
		Object[] args = new Object[] { company.getName(), company.getLocation() };
		int types[] = new int[] { Types.VARCHAR, Types.VARCHAR };

		jdbcTemplate.update(sql, args, types);

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub

	}

}
