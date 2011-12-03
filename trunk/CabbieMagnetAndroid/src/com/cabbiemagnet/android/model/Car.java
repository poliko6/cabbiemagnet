package com.cabbiemagnet.android.model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Dec 02, 2011
 * @time 6:46:02 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename Car.java
 * @description 
 * ================================================================================
 */
public class Car implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long id;
	private String type;
	private int maxSeats;

	private int maxHandicappedSeats;
	
	private int maxHoldBags;
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
		this.maxHoldBags = maxHoldBags;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", maxSeats=" + maxSeats
				+ ", maxHandicappedSeats=" + maxHandicappedSeats
				+ ", MaxHoldBags=" + maxHoldBags + "]";
	}
	
	

}
