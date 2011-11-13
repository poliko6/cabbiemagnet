package com.cabbiemagnet.webservices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:47:09 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.webservices	
 * @filename Common.java
 * @description 
 * ================================================================================
 */
public class Common {

	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if (context == null) {
			context = new FileSystemXmlApplicationContext(
					"classpath:applicationContext.xml");
			return context;
		}
		return context;
	}
}
