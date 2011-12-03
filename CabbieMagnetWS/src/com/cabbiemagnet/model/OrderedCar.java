package com.cabbiemagnet.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:46:48 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename OrderedCar.java
 * @description 
 * ================================================================================
 */
@XmlRootElement (name = "ordered_car")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement (name = "car_id")
	private long carId;
	
	@XmlElement (name="order_id")
	private long orderId;
	
	@XmlElement (name = "type")
	private String type;
	
	@XmlElement (name = "quantity")
	private int quantity;
	
	
	public long getCarId() {
		return carId;
	}
	// getters and setters
	public long getOrderId() {
		return orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getType() {
		return type;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId; 
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "OrderedCar [carId=" + carId + ", orderId=" + orderId
				+ ", type=" + type + ", quantity=" + quantity + "]";
	}

	
}
