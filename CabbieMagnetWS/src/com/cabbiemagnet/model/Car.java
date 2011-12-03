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
 * @time 6:46:02 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename Car.java
 * @description 
 * ================================================================================
 */
@XmlRootElement (name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement (name="id")
	private long id;
	
	@XmlElement (name = "type")
	private String type;
	
	@XmlElement (name="max_seats")
	private int maxSeats;
	
	@XmlElement (name="max_handicapped_seats")
	private int maxHandicappedSeats;
	
	@XmlElement (name="max_hold_bags")
	private int maxHoldBags;
	
	@XmlElement (name = "service")
	private ArrayList<Service> services;

	public Car() {};
	
	public long getId() {
		return id;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getMaxHandicappedSeats() {
		return maxHandicappedSeats;
	}

	public void setMaxHandicappedSeats(int maxHandicappedSeats) {
		this.maxHandicappedSeats = maxHandicappedSeats;
	}

	public int getMaxHoldBags() {
		return maxHoldBags;
	}

	public void setMaxHoldBags(int maxHoldBags) {
		maxHoldBags = maxHoldBags;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", maxSeats=" + maxSeats
				+ ", maxHandicappedSeats=" + maxHandicappedSeats
				+ ", MaxHoldBags=" + maxHoldBags + "]";
	}
	
	

}
