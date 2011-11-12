package com.cabbiemagnet.webservices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Common {
	
	//final static ApplicationContext context = new  FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	 private static ApplicationContext context;
	
	public static ApplicationContext getContext()
	{
		if (context == null)
		{
			context = new  FileSystemXmlApplicationContext("classpath:applicationContext.xml");
			return context;
		}
		return context;
	}

}
