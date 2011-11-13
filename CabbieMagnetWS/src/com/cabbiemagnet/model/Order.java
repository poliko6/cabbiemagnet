package com.cabbiemagnet.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.cabbiemagnet.dao.mapper.DateAdapter;

@XmlRootElement(name = "Order")
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
	private String orderReplyMessage;

	
	private Timestamp orderReplyTime;


	private Timestamp orderReplyTimeToDeliver;

	private ArrayList<OrderedCar> cars;

	public ArrayList<OrderedCar> getCars() {
		return cars;
	}

	public void setCars(ArrayList<OrderedCar> cars) {
		this.cars = cars;
	}

	@XmlElement(name = "orderReplyTImeToDeliver")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Timestamp getOrderReplyTimeToDeliver() {
		return orderReplyTimeToDeliver;
	}

	public void setOrderReplyTimeToDeliver(Timestamp orderReplyTimeToDeliver) {
		this.orderReplyTimeToDeliver = orderReplyTimeToDeliver;
	}
	
	@XmlElement(name = "orderReplyTime")
	@XmlJavaTypeAdapter(DateAdapter.class)
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
	@XmlElement(name = "timeOrdered", required=true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Timestamp getTimeOrdered() {
		return timeOrdered;
	}

	public void setTimeOrdered(Timestamp timeOrdered) {
		this.timeOrdered = timeOrdered;
	}
	
	
	public void setRequestedTimeToDeliver(Timestamp timeToDeliver) {
		this.requestedTimeToDeliver = timeToDeliver;
	}
	
	@XmlElement(name = "requestedTimeToDeliver")
	@XmlJavaTypeAdapter(DateAdapter.class)
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
