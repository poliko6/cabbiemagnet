package com.cabbiemagnet.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String type;
	private int maxSeats;
	private int maxHandicappedSeats;
	private int MaxHoldBags;
	private ArrayList<Service> services;

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
		return MaxHoldBags;
	}

	public void setMaxHoldBags(int maxHoldBags) {
		MaxHoldBags = maxHoldBags;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", maxSeats=" + maxSeats
				+ ", maxHandicappedSeats=" + maxHandicappedSeats
				+ ", MaxHoldBags=" + MaxHoldBags + "]";
	}
	
	

}
