package com.cabbiemagnet.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:46:12 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename Company.java
 * @description 
 * ================================================================================
 */
@XmlRootElement (name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private long id;
	@XmlElement
	private String name;
	@XmlElement
	private String loginName;
	@XmlElement
	private String password;
	@XmlElement
	private String location;
	@XmlElement
	private String rating;	
	@XmlElement(name = "car")
	private ArrayList<Car> cars;
	
	public Company() {};	// jaxb likes this
	
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public long getId() {
		return id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", loginName="
				+ loginName + ", password=" + password + ", location="
				+ location + ", rating=" + rating + "]";
	}
	
	
	
	
}
