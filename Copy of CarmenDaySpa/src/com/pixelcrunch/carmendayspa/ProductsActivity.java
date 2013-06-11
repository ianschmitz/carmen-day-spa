package com.pixelcrunch.carmendayspa;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProductsActivity extends Activity {
	SharedPreferences prefs;
	boolean isEmpty;

	ListView list;
	ProductListAdapter adapter;
	ProductRetrieval products;
	// we use a string to hold the name of our extra,
	// it must include the full package name
	// used to send selected product to the product page
	public final static String ID_EXTRA = "com.pixelcrunch.carmendayspa._ID";

	// Used to keep track of cart button
	private int itemAddedToCart = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.products_layout);

		if (!isCartEmpty()) {
			Button actionBarCart = (Button) findViewById(R.id.btnActionBarCart);
			actionBarCart.setVisibility(View.VISIBLE);

			actionBarCart.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {

					Intent i = new Intent(getApplicationContext(),
							CartActivity.class);
					startActivity(i);
				}
			});
		}

		// Get the list of products and their information,
		// store the info into string arrays used in creating
		// our list of products.
		try {
			products = new ProductRetrieval();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> productImageURL = products.getImageURL();
		List<String> productDescriptions = products.getProductDescriptions();
		List<String> productPrices = products.getProductPrices();

		// Creates the list where each item corresponds to a ListAdapter Item
		list = (ListView) findViewById(R.id.list);

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

			itemAddedToCart = 0;
			// Returns result from SingleProduct. If 1 then we know a product
			// was added
			// and can set cart button visible.
			startActivityForResult(i, itemAddedToCart);

		}
	};

	// this is the method that call when Activity result comes
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// check whether result comes with RESULT_OK (That mean no problem
		// in result)
		if (resultCode == RESULT_OK) {
			Crouton.makeText(this,
					getString(R.string.addedToCart), Style.INFO).show();
			
			Button actionBarCart = (Button) findViewById(R.id.btnActionBarCart);
			actionBarCart.setVisibility(View.VISIBLE);
			actionBarCart.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {

					Intent i = new Intent(getApplicationContext(),
							CartActivity.class);
					startActivity(i);
				}
			});
		}

	}

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

	public boolean isCartEmpty() {
		prefs = this.getSharedPreferences("carmen_cart", Context.MODE_PRIVATE);
		Map<String, ?> keys = prefs.getAll();

		Map<String, ?> emptyCheck = prefs.getAll();

		if (emptyCheck.size() == 0) {
			return true;
		}

		return false;

	}

}