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
@XmlRootElement (name = "orderedCar")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private long carId;
	@XmlElement
	private long orderId;
	@XmlElement
	private String type;
	@XmlElement
	private int quantity;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId; 
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	@Override
	public String toString() {
		return "OrderedCar [carId=" + carId + ", orderId=" + orderId
				+ ", type=" + type + ", quantity=" + quantity + "]";
	}

	
}
