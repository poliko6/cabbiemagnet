package com.cabbiemagnet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Timestamp;

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
	private Timestamp timeOrdered;
	private Timestamp requestedTimeToDeliver;
	private String fromLocation;
	private String toLocation;
	private String customerNote;
	private ArrayList<Car> cars;
	private String orderReply;
	private Timestamp orderReplyTime;
	private Timestamp orderReplyTimeToDeliver;
	
	
	public Timestamp getOrderReplyTimeToDeliver() {
		return orderReplyTimeToDeliver;
	}
	public void setOrderReplyTimeToDeliver(Timestamp orderReplyTimeToDeliver) {
		this.orderReplyTimeToDeliver = orderReplyTimeToDeliver;
	}
	public Timestamp getOrderReplyTime() {
		return orderReplyTime;
	}
	public void setOrderReplyTime(Timestamp orderReplyTime) {
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
	public Timestamp getTimeOrdered() {
		return timeOrdered;
	}
	public void setTimeOrdered(Timestamp timeOrdered) {
		this.timeOrdered = timeOrdered;
	}

	public void setRequestedTimeToDeliver(Timestamp timeToDeliver) {
		this.requestedTimeToDeliver = timeToDeliver;
	}
	public Timestamp getRequestedTimeToDeliver() {
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
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	public String getOrderReply() {
		return orderReply;
	}
	public void setOrderReply(String orderReply) {
		this.orderReply = orderReply;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", company="
				+ company + ", state=" + state + ", timeOrdered=" + timeOrdered
				+ ", timeToDeliver=" + requestedTimeToDeliver + ", fromLocation="
				+ fromLocation + ", toLocation=" + toLocation
				+ ", customerNote=" + customerNote + ", cars=" + cars
				+ ", orderReply=" + orderReply + "]";
	}
	
	

}
