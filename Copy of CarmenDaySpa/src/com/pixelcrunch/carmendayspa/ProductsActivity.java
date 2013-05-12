package com.pixelcrunch.carmendayspa;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProductsActivity extends Activity {

	ListView list;
	ProductListAdapter adapter;
	ProductRetrieval products;
	// we use a string to hold the name of our extra,
	// it must include the full package name
	// used to send selected product to the product page
	public final static String ID_EXTRA = "com.pixelcrunch.carmendayspa._ID";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.products_layout);

		// Creates the list where each item corresponds to a ListAdapter Item
		list = (ListView) findViewById(R.id.list);

		// Get the list of products and their information,
		// store the info into string arrays used in creating
		// our list of products.
		products = new ProductRetrieval();
		List<String> productImageURL = products.getImageURL();
		List<String> productDescriptions = products.getProductDescriptions();
		List<String> productPrices = products.getProductPrices();

		adapter = new ProductListAdapter(this, productImageURL,
				productDescriptions, productPrices);
		list.setAdapter(adapter);

		// Set up action bar Title
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.products);

		/**
		 * Clicking either the back button or the title on the action bar will
		 * bring you back to the home screen
		 */
		actionBarTitle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching Home Screen
				Intent i = new Intent(getApplicationContext(), Home.class);
				startActivity(i);
			}
		});

		// ActionBar Back button
		Button btnActionBarBack = (Button) findViewById(R.id.btnActionBarBack);

		// Listening Back button click
		btnActionBarBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching Home Screen
				Intent i = new Intent(getApplicationContext(), Home.class);
				startActivity(i);
			}
		});

		// ** INSERT IF STATEMENT TO MAKE SURE THERE ARE MORE ITEMS ON THE PHP
		// FILE, IF NOT DISABLE THE MORE BUTTON**
		// More button
		Button btnMore = (Button) findViewById(R.id.btnMore);

		// Listening More button click
		btnMore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Code to load the next 10 items from the php script

			}
		});

		/**
		 * onItemClickListener for our ListView
		 */
		list.setOnItemClickListener(onListClick);

	}

	/**
	 * Will get which product the user has selected using onItemClickListener.
	 * Then send the product data from that product to a new activity that will
	 * be waiting for the info to start the product purchase page.
	 */
	private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// Create intent
			Intent i = new Intent(ProductsActivity.this, SingleProduct.class);
			i.putExtra(ID_EXTRA, String.valueOf(id));
			startActivity(i);
		}
	};

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

}