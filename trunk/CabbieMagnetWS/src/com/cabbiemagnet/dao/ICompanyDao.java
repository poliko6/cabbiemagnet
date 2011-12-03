package com.cabbiemagnet.dao;

import java.util.ArrayList;
import com.cabbiemagnet.model.Company;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:44:18 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao	
 * @filename ICompanyDao.java
 * @description 
 * ================================================================================
 */
public interface ICompanyDao {

	void delete(Company company);
	ArrayList<Company> findByLocation(String location);
	ArrayList<Company> readAll();
	void save(Company company);
	void update(Company company);
}
