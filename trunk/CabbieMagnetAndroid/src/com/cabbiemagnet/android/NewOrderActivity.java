package com.cabbiemagnet.android;

import java.util.List;
import java.util.Locale;

import com.cabbiemagnet.android.MyLocationHelper.LocationResult;
import com.cabbiemagnet.android.model.Order;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewOrderActivity extends Activity {

	private final static String TAG = "NewOrderActivty";

	Geocoder geocoder;
	private Location currentLocation;
	private MyLocationHelper myLocationHelper = new MyLocationHelper();

	/* fields & buttons */
	Button findLocation;
	Button getCompanies;
	Button getMapsFromButton;
	Button getMapsToButton;

	EditText fromAddress;
	EditText toAddress;
	EditText fromCity;
	EditText toCity;

	TextView companyLabel;

	Order newOrder;

	boolean getMapFromWasPressed = false;
	boolean getMapToWasPressed = false;
	boolean findMeWasPressed = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.new_order);

		findLocation = (Button) findViewById(R.id.findme_button);
		getCompanies = (Button) findViewById(R.id.get_company_button);
		getMapsFromButton = (Button) findViewById(R.id.get_map_button);
		getMapsToButton = (Button) findViewById(R.id.get_from_onmap_button);

		fromAddress = (EditText) findViewById(R.id.from_address_field);
		toAddress = (EditText) findViewById(R.id.to_address_field);
		fromCity = (EditText) findViewById(R.id.from_city_field);
		toCity = (EditText) findViewById(R.id.to_city_field);

		companyLabel = (TextView) findViewById(R.id.company_label);

		setOnClickListeners();
	}

	private void setOnClickListeners() {
		getCompanies.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NewOrderActivity.this,
						CompaniesActivity.class);
				Bundle b = new Bundle();
				String location = fromCity.getText().toString();
				b.putString("location", location);
				intent.putExtras(b);
				NewOrderActivity.this.startActivityForResult(intent,
						Globals.ACTIVITY_COMPANIES);
			}
		});

		findLocation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				findMeWasPressed = true;
				getLocation();
			}
		});

		getMapsFromButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getMapFromWasPressed = true;
				getLocation();

			}
		});

		getMapsToButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getMapToWasPressed = true;
				getLocation();
			}
		});
	}

	/*
	 * this gets the location returned in locationResult from LocationResult
	 * class implemented here in the Main Activity.
	 */
	public void getLocation() {
		try {
			myLocationHelper.getLocation(this, locationResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(NewOrderActivity.this, e.getMessage(),
					Toast.LENGTH_LONG).show();
			Log.d(TAG,
					"getLocation(): Problem occured while looking for a new location");
		}
	}

	/*
	 * This is what to do when we got a location. Here is were we retrieve the
	 * photos. implementation of the abstract class
	 */
	private LocationResult locationResult = new LocationResult() {
		@Override
		public void gotLocation(Location location) {
			// Got the location!
			if (location != null) {
				currentLocation = location;

				// do after location is found
				if (findMeWasPressed) {
					getLocationAddress();
				}

				if (getMapFromWasPressed) {

					getMapFromWasPressed = false;
					Intent intent = new Intent(NewOrderActivity.this,
							GoogleMapsView.class);
					Bundle b = new Bundle();
					b.putDouble("LATITUDE", currentLocation.getLatitude());
					b.putDouble("LONGITUDE", currentLocation.getLongitude());

					intent.putExtras(b);
					NewOrderActivity.this.startActivityForResult(intent,
							Globals.ACTIVITY_GOOGLE_MAPS_FROM);
				}
				if (getMapToWasPressed) {
					getMapToWasPressed = false;
					Intent intent = new Intent(NewOrderActivity.this,
							GoogleMapsView.class);
					Bundle b = new Bundle();
					b.putDouble("LATITUDE", currentLocation.getLatitude());
					b.putDouble("LONGITUDE", currentLocation.getLongitude());

					intent.putExtras(b);
					NewOrderActivity.this.startActivityForResult(intent,
							Globals.ACTIVITY_GOOGLE_MAPS_TO);
				}
			}
		}

	};

	private void getLocationAddress() {

		geocoder = new Geocoder(this, Locale.getDefault());

		try {
			List<Address> addresses = geocoder.getFromLocation(
					currentLocation.getLatitude(),
					currentLocation.getLongitude(), 1);

			if (addresses != null) {
				String fromAddressStr = new String();
				String fromCityStr = new String();

				Address returnedAddress = addresses.get(0);
				fromAddressStr = returnedAddress.getAddressLine(0);
				fromCityStr = returnedAddress.getSubAdminArea();

				this.fromAddress.setText(fromAddressStr);
				this.fromCity.setText(fromCityStr);
				this.toCity.setText(fromCityStr);
			}

		} catch (Exception e) {

		}

	};

	/**
	 * Data handled when coming back from activities started from this Activity
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		// when coming back from Google Maps
		case Globals.ACTIVITY_GOOGLE_MAPS_FROM: {
			if (resultCode == Activity.RESULT_OK) {
				Bundle b = data.getExtras();
				fromAddress.setText(b.getString("address"));
				fromCity.setText(b.getString("city"));
			}
			break;
		}
		case Globals.ACTIVITY_GOOGLE_MAPS_TO: {
			if (resultCode == Activity.RESULT_OK) {
				Bundle b = data.getExtras();
				toAddress.setText(b.getString("address"));
				toCity.setText(b.getString("city"));

			}
			break;
		}
		case Globals.ACTIVITY_COMPANIES: {
			if (resultCode == Activity.RESULT_OK) {
				Bundle b = data.getExtras();
				companyLabel.setText("Company: " + b.getString("company_name"));
				// order.setCompanyid(b.getLong("company_id"));

			}

		}
		}
	}
}
