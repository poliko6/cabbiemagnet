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
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Company company) {

		String sql = "INSERT INTO COMPANIES (NAME, LOCATION) VALUES(?,?)";
		Object[] args = new Object[] { company.getName(), company.getLocation() };
		int types[] = new int[] { Types.VARCHAR, Types.VARCHAR };

		jdbcTemplate.update(sql, args, types);

	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Company> findByLocation(String location) {
		String sql = "select * from COMPANY where location=? ORDER BY RATING_AVG DESC";
		Object[] args = new Object[] { location };
		return (ArrayList<Company>) jdbcTemplate.query(sql, args, new CompanyRowMapper());
	}

	@Override
	public ArrayList<Company> readAll() {
		ArrayList<Company> companies = new ArrayList<Company>();
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Service> services = new ArrayList<Service>();

		
		String sqlCars = "SELECT car.id, car.type, car.max_seats, car.max_handicapped_seats, car.max_hold_bags " +
				"FROM company_has_cars " +
				"JOIN company ON company.id = company_has_cars.company_id " +
				"JOIN car ON car.id = company_has_cars.car_id " +
				"WHERE company_has_cars.company_id = ?";
		
		String sqlServices = "select service.id, service.name " +
				"from car_has_services " +
				"JOIN Service ON " +
				"service.id = car_has_services.service_id " +
				"JOIN Car ON " +
				"car.id = car_has_services.car_id " +
				"where car_has_services.car_id = ?";
		
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

}
