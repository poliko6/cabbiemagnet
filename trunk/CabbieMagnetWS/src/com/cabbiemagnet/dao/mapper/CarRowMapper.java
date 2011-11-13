package com.cabbiemagnet.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Car;

/**
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:43:56 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.mapper	
 * @filename CarRowMapper.java
 * @description rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 * ================================================================================
 */
public class CarRowMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int line) throws SQLException {
		
		Car car = new Car();
		car.setId(rs.getLong("ID"));
		car.setType(rs.getString("TYPE"));
		car.setMaxSeats(rs.getInt("MAX_SEATS"));
		car.setMaxHandicappedSeats(rs.getInt("MAX_HANDICAPPED_SEATS"));
		car.setMaxHoldBags(rs.getInt("MAX_HOLD_BAGS"));
		return car;
	}

}