package com.cabbiemagnet.android.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.cabbiemagnet.android.Globals;
import com.cabbiemagnet.android.RestClient;
import com.cabbiemagnet.android.RestClient.RequestMethod;
import com.cabbiemagnet.android.model.Order;
import com.cabbiemagnet.android.model.OrderedCar;

public class OrderService {

	private static String TAG = "OrderService";

	private RestClient client;

	public OrderService() {
		client = RestClient.getInstance();
	}

	public void addNewOrder(Order order) {
		client.setUrl(Globals.BASE_URL_ORDERS_NEW);

		// TODO finish that thing !!!!
		// gotta post some json here or change the webservice
	}

	public ArrayList<Order> getOrders(String phonenum) throws Exception {
		ArrayList<Order> orders = new ArrayList<Order>();

		client.setUrl(Globals.BASE_URL_ORDERS_CUSTOMER + phonenum);
		client.clearParams();
		client.Execute(RequestMethod.GET);

		int responseCode = client.getResponseCode();

		// OK
		if (responseCode == 200) {
			JSONArray ordersJson = client.convertStringToJSONArray(client
					.getResponse());
			// if there are no orders found (either no such customer id or just
			// no orders
			if (ordersJson.isNull(0)) {
				throw new Exception("There were no orders found!");
			}

			// parse json
			for (int i = 0; i < ordersJson.length(); i++) {
				JSONObject orderJson = ordersJson.getJSONObject(i);
				Order order = new Order();

				order.setId(orderJson.getLong("id"));
				order.setCustomerId(orderJson.getLong("customer_id"));
				order.setCustomer(orderJson.getString("customer_name"));
				order.setCompanyId(orderJson.getLong("company_id"));
				order.setCompany(orderJson.getString("company_name"));
				order.setState(orderJson.getString("order_state"));

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-d hh:mm:ss");
				java.util.Date date = sdf.parse(orderJson
						.getString("time_ordered"));
				java.sql.Timestamp timest = new java.sql.Timestamp(
						date.getTime());
				order.setTimeOrdered(timest);

				date = sdf.parse(orderJson
						.getString("requested_time_to_deliver"));
				timest = new Timestamp(date.getTime());
				order.setRequestedTimeToDeliver(timest);

				if (orderJson.has("replied_time")) {
					date = sdf.parse(orderJson.getString("replied_time"));
					timest = new Timestamp(date.getTime());
					order.setOrderReplyTime(timest);
				}

				if (orderJson.has("replied_time_to_deliver")) {
					date = sdf.parse(orderJson
							.getString("replied_time_to_deliver"));
					timest = new Timestamp(date.getTime());
					order.setOrderReplyTimeToDeliver(timest);
				}

				order.setFromLocation(orderJson.getString("from_location"));
				order.setToLocation(orderJson.getString("to_location"));
				order.setCustomerNote(orderJson.getString("customer_note"));

				if (orderJson.has("replied_message")) {
					order.setOrderReplyMessage(orderJson
							.getString("replied_message"));
				}

				JSONArray carsJson = orderJson.getJSONArray("car");
				ArrayList<OrderedCar> cars = new ArrayList<OrderedCar>();

				for (int j = 0; j < carsJson.length(); j++) {
					OrderedCar car = new OrderedCar();
					JSONObject carJson = carsJson.getJSONObject(j);

					car.setCarId(carJson.getLong("car_id"));
					car.setOrderId(carJson.getLong("order_id"));
					car.setQuantity(carJson.getInt("quantity"));
					car.setType(carJson.getString("type"));
					cars.add(car);
				}

				order.setCars(cars);

				orders.add(order);
			}

			Log.v(TAG, "orders: " + orders.size());
			Log.v(TAG, "order1.car1 "
					+ orders.get(0).getCars().get(0).getType());

		} else {
			throw new Exception("Something went wrong. Code: " + responseCode);
		}

		return orders;
	}
}
