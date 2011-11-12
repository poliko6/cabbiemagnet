package com.cabbiemagnet.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String customer;
	private String company;
	private String state;
	private String timeOrdered;
	private String requestedTimeToDeliver;
	private String fromLocation;
	private String toLocation;
	private String customerNote;
	private String orderReplyMessage;
	private String orderReplyTime;
	private String orderReplyTimeToDeliver;
	private ArrayList<OrderedCar> cars;
	
	
	
	public ArrayList<OrderedCar> getCars() {
		return cars;
	}
	public void setCars(ArrayList<OrderedCar> cars) {
		this.cars = cars;
	}
	public String getOrderReplyTimeToDeliver() {
		return orderReplyTimeToDeliver;
	}
	public void setOrderReplyTimeToDeliver(String orderReplyTimeToDeliver) {
		this.orderReplyTimeToDeliver = orderReplyTimeToDeliver;
	}
	public String getOrderReplyTime() {
		return orderReplyTime;
	}
	public void setOrderReplyTime(String orderReplyTime) {
		this.orderReplyTime = orderReplyTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTimeOrdered() {
		return timeOrdered;
	}
	public void setTimeOrdered(String timeOrdered) {
		this.timeOrdered = timeOrdered;
	}

	public void setRequestedTimeToDeliver(String timeToDeliver) {
		this.requestedTimeToDeliver = timeToDeliver;
	}
	public String getRequestedTimeToDeliver() {
		return requestedTimeToDeliver;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getCustomerNote() {
		return customerNote;
	}
	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	public String getOrderReplyMessage() {
		return orderReplyMessage;
	}
	public void setOrderReplyMessage(String orderReplyMessage) {
		this.orderReplyMessage = orderReplyMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
