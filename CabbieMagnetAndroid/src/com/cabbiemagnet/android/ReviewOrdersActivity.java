package com.cabbiemagnet.android;

import java.util.ArrayList;
import java.util.HashMap;

import com.cabbiemagnet.android.model.Order;
import com.cabbiemagnet.android.services.OrderService;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ReviewOrdersActivity extends ListActivity {

	OrderService orderService;
	ArrayList<Order> orders;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.orders_listview); 
		
		Bundle b = getIntent().getExtras();
		String phonenum = b.getString("phonenum");
		
		orderService = new OrderService();
		
		try {
			orders = orderService.getOrders(phonenum);
			ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
			
			for (int i = 0; i < orders.size(); i++)
			{
				HashMap<String, String> map = new HashMap<String, String>();

				// for the map
				map.put("list_id", String.valueOf(i));
				map.put("id", "ID: "+ orders.get(i).getId());
				map.put("company_name", "Company: " + orders.get(i).getCompany());
				map.put("time_ordered", "Ordered: " + orders.get(i).getTimeOrdered());
				mylist.add(map);
			}
			
			 
			ListAdapter adapter = new SimpleAdapter(this, mylist,
					R.layout.orders_entries, new String[] {"id", "company_name",
							"time_ordered", "hidden_id" }, new int[] { R.id.order_id_label,
							R.id.order_company_label, R.id.order_time_label }); 

			setListAdapter(adapter);

			final ListView lv = getListView();
			lv.setTextFilterEnabled(true);
			lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					@SuppressWarnings("unchecked")
					HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
					int idSelected = Integer.valueOf(o.get("list_id"));
					
					Toast.makeText(ReviewOrdersActivity.this,
							"From: " + orders.get(idSelected).getFromLocation() + "\n"+
							"To: " + orders.get(idSelected).getToLocation() + "\n" + 
							"State: " + orders.get(idSelected).getState(),
							Toast.LENGTH_SHORT).show();

				}
			});
			

			
		} catch (Exception e) {
			Toast.makeText(ReviewOrdersActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		

		
	}
}
