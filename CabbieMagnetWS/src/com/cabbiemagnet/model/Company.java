package com.cabbiemagnet.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String loginName;
	private String password;
	private String location;
	private String rating;
	
	private ArrayList<Car> cars;
	
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
