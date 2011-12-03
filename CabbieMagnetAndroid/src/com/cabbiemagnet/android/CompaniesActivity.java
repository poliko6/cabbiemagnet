package com.cabbiemagnet.android;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cabbiemagnet.android.model.Car;
import com.cabbiemagnet.android.model.Company;
import com.cabbiemagnet.android.model.Service;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CompaniesActivity extends ListActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.companies_listview);

		Bundle b = getIntent().getExtras();
		String location = b.getString("location");

		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		// get the JSONobject requesting the REST service
		JSONArray json = JSONfunctions.getJSONfromURL(
				Globals.BASE_URL_COMPANIES + location, Globals.METHOD_GET);

		try {
			JSONArray companies = json;

			ArrayList<Company> companiesObjList = new ArrayList<Company>();

			for (int i = 0; i < companies.length(); i++) {

				HashMap<String, String> map = new HashMap<String, String>();

				// get company
				JSONObject company = companies.getJSONObject(i);
				Company companyObj = new Company();

				// for the map
				map.put("id", String.valueOf(i));
				map.put("name", company.getString("name"));
				map.put("location",
						"Location: " + company.getString("location"));
				map.put("rating", company.getString("rating"));
				mylist.add(map);

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
			Log.v("company0 name:", companiesObjList.get(0).getName());
			Log.v("asdhfs", "" + companiesObjList.get(0).getCars().size());

		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());
		}

		ListAdapter adapter = new SimpleAdapter(this, mylist,
				R.layout.companies_entries, new String[] { "name", "location",
						"rating" }, new int[] { R.id.company_name,
						R.id.company_location, R.id.company_rating });

		setListAdapter(adapter);

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv
						.getItemAtPosition(position);
				Toast.makeText(CompaniesActivity.this,
						"ID '" + o.get("id") + "' was clicked.",
						Toast.LENGTH_SHORT).show();

			}
		});

	}

}
