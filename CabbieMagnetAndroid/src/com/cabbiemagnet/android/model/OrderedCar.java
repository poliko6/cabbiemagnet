package com.cabbiemagnet.android.model;

import java.io.Serializable;

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

public class OrderedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long carId;
	private long orderId;
	private String type;
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
