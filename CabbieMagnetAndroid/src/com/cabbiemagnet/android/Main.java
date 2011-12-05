package com.cabbiemagnet.android;

import com.cabbiemagnet.android.services.CustomerService;
import com.cabbiemagnet.android.services.OrderService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	/** Called when the activity is first created. */

	private final static String TAG = "MainActivity";
	Button newOrderButton;
	Button loginButton;
	Button editUsernameButton;
	Button viewOrdersButton;
	Button registerButton;
	EditText phoneNumberField;
	EditText usernameField;
	TextView usernameLabel;
	
	CustomerService customerService;
	OrderService orderService;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		customerService = new CustomerService();
		orderService = new OrderService();
		
		newOrderButton = (Button) findViewById(R.id.new_order_button);
		loginButton = (Button) findViewById(R.id.login_button);
		editUsernameButton = (Button) findViewById(R.id.editName_button);
		registerButton = (Button) findViewById(R.id.register_button);
		viewOrdersButton = (Button) findViewById(R.id.view_orders_button);
		phoneNumberField = (EditText) findViewById(R.id.phonenumber_field);
		usernameField = (EditText) findViewById(R.id.username_field);
		phoneNumberField.setText("4521576567");
		usernameLabel = (TextView) findViewById(R.id.username_label);
		
		setButtonListeners();
		 
		// check for internet
		hasInternetConnection();
	}

	private void setButtonListeners() {
		newOrderButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Main.this, NewOrderActivity.class);
				Main.this.startActivity(intent);
			}
		});
		
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String n = phoneNumberField.getText().toString();
				try
				{
				String name = customerService.login(n);
				usernameLabel.setText(name);
				usernameField.setText(name);
				} catch (Exception e)
				{
					Toast.makeText(Main.this, e.getMessage(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		editUsernameButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// if username is entered
				if (!usernameField.getText().toString().equals(null))
				{
					try {
						String newName = customerService.changeName(phoneNumberField.getText().toString(), usernameField.getText().toString());
						usernameLabel.setText(newName);
						usernameField.setText(newName);
					} catch (Exception e) {
						Toast.makeText(Main.this, e.getMessage(), Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
				}
			}
		});
		
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// if number is entered
				if(!phoneNumberField.getText().toString().equals(null))
				{
					
					try {
						String username = customerService.register(phoneNumberField.getText().toString(), usernameField.getText().toString());
						usernameLabel.setText(username);
						usernameField.setText(username);
					} catch (Exception e) {
						Toast.makeText(Main.this, e.getMessage(), Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
				}
				
			}
		});
		
		viewOrdersButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (Main.this, ReviewOrdersActivity.class);
				
				try {
					orderService.getOrders(phoneNumberField.getText().toString());
				} catch (Exception e) {
					Toast.makeText(Main.this, e.getMessage(), Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Check if Internet connection is available and is connected
	 * 
	 * @return boolean
	 */
	private boolean hasInternetConnection() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		// test for connection
		if (cm.getActiveNetworkInfo() != null
				&& cm.getActiveNetworkInfo().isAvailable()
				&& cm.getActiveNetworkInfo().isConnected()) {
			Log.v(TAG, "Internet Connection Present");
			return true;
		} else {
			Toast.makeText(this, R.string.internet_no_connection,
					Toast.LENGTH_LONG).show();
			Log.v(TAG, "Internet Connection Not Present");
			return false;
		}
	}

}