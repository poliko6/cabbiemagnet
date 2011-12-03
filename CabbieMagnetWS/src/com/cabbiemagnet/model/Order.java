package com.cabbiemagnet.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.cabbiemagnet.dao.mapper.DateAdapter;

/**
 * 
 * ============================================================================
 * ====
 * 
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:46:37 PM
 * 
 * @project CabbieMagnetWS
 * @package com.cabbiemagnet.model
 * @filename Order.java
 * @description 
 *              ==================================================================
 *              ==============
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement (name = "id")
	private long id;
	
	@XmlElement (name = "customer_id")
	private long customerId;
	@XmlElement ( name = "customer_name")
	private String customer;
	
	@XmlElement (name = "company_id")
	private long companyId;
	@XmlElement (name = "company_name")
	private String company;
	
	@XmlElement (name = "order_state")
	private String state;

	@XmlElement(name = "time_ordered")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Timestamp timeOrdered;

	@XmlElement(name = "requested_time_to_deliver", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Timestamp requestedTimeToDeliver;

	@XmlElement (name = "from_location")
	private String fromLocation;
	
	@XmlElement (name = "to_location")
	private String toLocation;
	
	@XmlElement (name = "customer_note")
	private String customerNote;
	
	@XmlElement (name = "replied_message")
	private String orderReplyMessage;

	@XmlElement(name = "replied_time")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Timestamp orderReplyTime;

	// annotate this element and give it a type adapter
	// so that timestamps are translated correctly from the database
	// we use this custom made adapter to do that
	@XmlElement(name = "replied_time_to_deliver")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Timestamp orderReplyTimeToDeliver;

	@XmlElement(name = "car")
	private ArrayList<OrderedCar> cars;

	
	
	
	
	public ArrayList<OrderedCar> getCars() {
		return cars;
	}

	public void setCars(ArrayList<OrderedCar> cars) {
		this.cars = cars;
	}

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

	public String getOrderReplyMessage() {
		return orderReplyMessage;
	}

	public void setOrderReplyMessage(String orderReplyMessage) {
		this.orderReplyMessage = orderReplyMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", company="
				+ company + ", state=" + state + ", timeOrdered=" + timeOrdered
				+ ", requestedTimeToDeliver=" + requestedTimeToDeliver
				+ ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", customerNote=" + customerNote
				+ ", orderReplyMessage=" + orderReplyMessage
				+ ", orderReplyTime=" + orderReplyTime
				+ ", orderReplyTimeToDeliver=" + orderReplyTimeToDeliver
				+ ", cars=" + cars + "]";
	}

}
