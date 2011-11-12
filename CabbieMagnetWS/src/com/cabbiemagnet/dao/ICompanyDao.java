package com.cabbiemagnet.dao;

import java.util.ArrayList;
import com.cabbiemagnet.model.Company;

public interface ICompanyDao {

	void save(Company company);
	void update(Company company);
	void delete(Company company);
	ArrayList<Company> findByLocation(String location);
	ArrayList<Company> readAll();
}
