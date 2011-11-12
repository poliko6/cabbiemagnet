package com.cabbiemagnet.webservices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Common class that has static singleton methods to be used from the services
 * TO BE REMOVED - only work in progress
 * 
 * @author anlazarov
 * 
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
