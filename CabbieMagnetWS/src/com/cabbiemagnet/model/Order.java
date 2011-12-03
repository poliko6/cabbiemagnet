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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
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

	public String getCompany() {
		return company;
	}

	public long getCompanyId() {
		return companyId;
	}

	public String getCustomer() {
		return customer;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public long getId() {
		return id;
	}

	public String getOrderReplyMessage() {
		return orderReplyMessage;
	}

	public Timestamp getOrderReplyTime() {
		return orderReplyTime;
	}

	public Timestamp getOrderReplyTimeToDeliver() {
		return orderReplyTimeToDeliver;
	}

	public Timestamp getRequestedTimeToDeliver() {
		return requestedTimeToDeliver;
	}

	public String getState() {
		return state;
	}

	public Timestamp getTimeOrdered() {
		return timeOrdered;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setCars(ArrayList<OrderedCar> cars) {
		this.cars = cars;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrderReplyMessage(String orderReplyMessage) {
		this.orderReplyMessage = orderReplyMessage;
	}

	public void setOrderReplyTime(Timestamp orderReplyTime) {
		this.orderReplyTime = orderReplyTime;
	}

	public void setOrderReplyTimeToDeliver(Timestamp orderReplyTimeToDeliver) {
		this.orderReplyTimeToDeliver = orderReplyTimeToDeliver;
	}
	

	public void setRequestedTimeToDeliver(Timestamp timeToDeliver) {
		this.requestedTimeToDeliver = timeToDeliver;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	public void setTimeOrdered(Timestamp timeOrdered) {
		this.timeOrdered = timeOrdered;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
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
