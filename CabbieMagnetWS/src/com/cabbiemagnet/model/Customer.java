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
 * @time 6:46:20 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename Customer.java
 * @description 
 * ================================================================================
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement (name = "id")
	private long id;
	@XmlElement (name="name")
	private String name;
	
	public Customer() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	

}
