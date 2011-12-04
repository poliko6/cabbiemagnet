package com.cabbiemagnet.android;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cabbiemagnet.android.model.Car;
import com.cabbiemagnet.android.model.Company;
import com.cabbiemagnet.android.model.Service;
import com.cabbiemagnet.android.services.CompanyService;

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

	CompanyService companyService;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.companies_listview);

		// get th location from the prev intent
		Bundle b = getIntent().getExtras();
		String location = b.getString("location");

		// create the service
		companyService = new CompanyService();
		// get the companies
		ArrayList<Company> companiesObjList = companyService
				.getCompanies(location);

		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < companiesObjList.size(); i++)
		{
			HashMap<String, String> map = new HashMap<String, String>();

			// for the map
			map.put("id", String.valueOf(i));
			map.put("name", companiesObjList.get(i).getName());
			map.put("location", "Location: " + companiesObjList.get(i).getLocation());
			map.put("rating", companiesObjList.get(i).getRating());
			mylist.add(map);
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
