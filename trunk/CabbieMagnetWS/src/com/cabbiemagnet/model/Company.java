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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@XmlElement (name="id")
	private long id;
	
	@XmlElement (name="name")
	private String name;
	
	@XmlElement (name="login_name")
	private String loginName;
	
	@XmlElement (name = "password")
	private String password;
	
	@XmlElement (name = "location")
	private String location;	
	
	@XmlElement (name = "rating")
	private String rating;
	
	@XmlElement(name = "car")
	private ArrayList<Car> cars;;	// jaxb likes this
	
	public Company() {}
	public ArrayList<Car> getCars() {
		return cars;
	}
	public long getId() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public String getLoginName() {
		return loginName;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getRating() {
		return rating;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", loginName="
				+ loginName + ", password=" + password + ", location="
				+ location + ", rating=" + rating + "]";
	}
	
	
	
	
}
