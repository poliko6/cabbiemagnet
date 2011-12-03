package com.cabbiemagnet.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:46:56 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.model	
 * @filename Service.java
 * @description 
 * ================================================================================
 */
@XmlRootElement (name="service")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "id")
	private long id;
	
	@XmlElement(name = "name")
	private String name;
	
	public Service() {};

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
		return "Service [id=" + getId() + ", name=" + getName() + "]";
	}
	
	
}
