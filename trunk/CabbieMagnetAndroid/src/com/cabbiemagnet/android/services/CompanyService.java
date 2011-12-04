package com.cabbiemagnet.android.services;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.cabbiemagnet.android.Globals;
import com.cabbiemagnet.android.RestClient;
import com.cabbiemagnet.android.RestClient.RequestMethod;
import com.cabbiemagnet.android.model.Car;
import com.cabbiemagnet.android.model.Company;
import com.cabbiemagnet.android.model.Service;

public class CompanyService {
	private RestClient client;

	public CompanyService() {
		client = RestClient.getInstance();
	}

	public ArrayList<Company> getCompanies(String location) {
		client.setUrl(Globals.BASE_URL_COMPANIES + location);
		ArrayList<Company> companiesObjList = new ArrayList<Company>();

		try {
			client.Execute(RequestMethod.GET);
			String responseString = client.getResponse();
			JSONArray companies = client
					.convertStringToJSONArray(responseString);

			try {
				for (int i = 0; i < companies.length(); i++) {

					// get company
					JSONObject company = companies.getJSONObject(i);
					Company companyObj = new Company();

					// get company's properties
					companyObj.setId(company.getLong("id"));
					companyObj.setName(company.getString("name"));
					companyObj.setLocation(company.getString("location"));

					// get company's cars
					JSONArray cars = company.getJSONArray("car");
					ArrayList<Car> carsObjList = new ArrayList<Car>();
					// get each car
					for (int j = 0; j < cars.length(); j++) {
						JSONObject car = cars.getJSONObject(j);
						Car carObj = new Car();

						// set car's properties
						//
						carObj.setId(car.getLong("id"));
						carObj.setType(car.getString("type"));
						carObj.setMaxSeats(car.getInt("max_seats"));
						carObj.setMaxHandicappedSeats(car
								.getInt("max_handicapped_seats"));
						carObj.setMaxHoldBags(car.getInt("max_hold_bags"));

						// set car services
						JSONArray services = car.getJSONArray("service");
						ArrayList<Service> servicesObjList = new ArrayList<Service>();

						for (int k = 0; k < services.length(); k++) {
							JSONObject service = services.getJSONObject(k);
							// set service's properties
							//
							Service serviceObj = new Service();
							serviceObj.setId(service.getLong("id"));
							serviceObj.setName(service.getString("name"));

							servicesObjList.add(serviceObj);
						}
						// add services to the car
						carObj.setServices(servicesObjList);

						// add the car to a car list
						carsObjList.add(carObj);

					}
					// add cars to the company
					companyObj.setCars(carsObjList);

					// add the company to company list
					companiesObjList.add(companyObj);

				} // end of last for loop

				Log.v("companies-size:", "" + companiesObjList.size());
				Log.v("company0 rating:", companiesObjList.get(0).getRating());
				Log.v("first company's cars size", "" + companiesObjList.get(0).getCars().size());

			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return companiesObjList;
	}

}
