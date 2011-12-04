package com.cabbiemagnet.android.services;

import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.widget.Toast;

import com.cabbiemagnet.android.Globals;
import com.cabbiemagnet.android.NewOrderActivity;
import com.cabbiemagnet.android.RestClient;
import com.cabbiemagnet.android.RestClient.RequestMethod;

public class CustomerService {
	
	private RestClient client;
	
	
	public CustomerService()
	{
		client = RestClient.getInstance();
	}
	
	public String login(String phoneNumber) throws Exception
	{
		client.setUrl(Globals.BASE_URL_CUSTOMERS_GET);
		
		client.clearParams();
		client.AddParam("id", phoneNumber);

			try {
				client.Execute(RequestMethod.GET);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int responseCode = client.getResponseCode();
			
			// ok
			if(responseCode == 200)
			{
				String s = client.getResponse();
				Log.v("loginResponse", s);
				return s;
				
			}
			// no content
			else if( responseCode == 204)
			{
				throw new NotFoundException("Not registered!");
			}
			else 
			{
				throw new Exception("Error! ResponseCode: " + responseCode);
			}
	}

	public String changeName(String phonenumber, String newName) throws Exception{

		client.setUrl(Globals.BASE_URL_CUSTOMERS_CHANGE);
		client.clearParams();
		
		client.AddParam("id", phonenumber);
		client.AddParam("name", newName);
		
		try {
			client.Execute(RequestMethod.PUT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int responseCode = client.getResponseCode();
		
		// ok
		if(responseCode == 200)
		{
			String s = client.getResponse();
			Log.v("loginResponse", s);
			return s;
			
		}
		// not modified
		else if( responseCode == 304)
		{
			throw new Exception("Not Modified");
		}
		else 
		{
			throw new Exception("Error! ResponseCode: " + responseCode);
		}
	}
	
	public String register(String phonenumber, String newName) throws Exception{

		client.setUrl(Globals.BASE_URL_CUSTOMERS_NEW);
		client.clearParams();
		
		client.AddParam("id", phonenumber);
		client.AddParam("name", newName);
		
		try {
			client.Execute(RequestMethod.POST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int responseCode = client.getResponseCode();
		
		// created
		if(responseCode == 201)
		{
			String s = client.getResponse();
			Log.v("loginResponse", s);
			return s;
			
		}
		// not modified
		else if( responseCode == 304)
		{
			throw new Exception("User already registered!");
		}
		else 
		{
			throw new Exception("Error! ResponseCode: " + responseCode);
		}
	}
	
}
