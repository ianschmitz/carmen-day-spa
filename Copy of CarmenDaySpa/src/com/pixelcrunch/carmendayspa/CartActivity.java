package com.pixelcrunch.carmendayspa;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CartActivity extends Activity {
	private ProductRetrieval products;
	public ProductImageLoader imageLoader;
	String passedVar = null;
	SharedPreferences prefs;

	TextView actionBarTitle;
	Button btnActionBarBack;

	RelativeLayout item1Holder;
	TextView tvItem1;
	Button btnItem1;
	RelativeLayout item2Holder;
	TextView tvItem2;
	Button btnItem2;
	RelativeLayout item3Holder;
	TextView tvItem3;
	Button btnItem3;
	RelativeLayout item4Holder;
	TextView tvItem4;
	Button btnItem4;
	RelativeLayout item5Holder;
	TextView tvItem5;
	Button btnItem5;
	RelativeLayout item6Holder;
	TextView tvItem6;
	Button btnItem6;
	RelativeLayout item7Holder;
	TextView tvItem7;
	Button btnItem7;
	RelativeLayout item8Holder;
	TextView tvItem8;
	Button btnItem8;
	RelativeLayout item9Holder;
	TextView tvItem9;
	Button btnItem9;

	Button btnRemoveAll;
	Button btnCheckOut;

	List<String> descriptions;
	List<String> prices;
	List<String> imageURLS;
	List<String> productNames;
	List<String> productQuantity;;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart_layout);

		setupActionBar();

		setupProductRetrieval();
		
		init();

		/**
		 * Get sharedPreferences for saving to cart
		 */
		prefs = this.getSharedPreferences("carmen_cart", Context.MODE_PRIVATE);
		Map<String, ?> keys = prefs.getAll();

		int count = 1;
		for (Map.Entry<String, ?> entry : keys.entrySet()) {
			int productID = getSelectedProduct(entry.getKey());
			String productString = "";
			productString += productNames.get(productID) + " - ";
			productString += String.valueOf(entry.getValue()) + " @ ";
			productString += prices.get(productID);

			tvItem1.setText(productString);
		}

	}

	private void init() {
		item1Holder = (RelativeLayout) findViewById(R.id.item1);
		tvItem1 = (TextView) findViewById(R.id.tvItem1);
		btnItem1 = (Button) findViewById(R.id.btnItem1);
		item2Holder = (RelativeLayout) findViewById(R.id.item2);
		tvItem2 = (TextView) findViewById(R.id.tvItem2);
		btnItem2 = (Button) findViewById(R.id.btnItem2);
		item3Holder = (RelativeLayout) findViewById(R.id.item3);
		tvItem3 = (TextView) findViewById(R.id.tvItem3);
		btnItem3 = (Button) findViewById(R.id.btnItem3);
		item4Holder = (RelativeLayout) findViewById(R.id.item4);
		tvItem4 = (TextView) findViewById(R.id.tvItem4);
		btnItem4 = (Button) findViewById(R.id.btnItem4);
		item5Holder = (RelativeLayout) findViewById(R.id.item5);
		tvItem5 = (TextView) findViewById(R.id.tvItem5);
		btnItem5 = (Button) findViewById(R.id.btnItem5);
		item6Holder = (RelativeLayout) findViewById(R.id.item6);
		tvItem6 = (TextView) findViewById(R.id.tvItem6);
		btnItem6 = (Button) findViewById(R.id.btnItem6);
		item7Holder = (RelativeLayout) findViewById(R.id.item7);
		tvItem7 = (TextView) findViewById(R.id.tvItem7);
		btnItem7 = (Button) findViewById(R.id.btnItem7);
		item8Holder = (RelativeLayout) findViewById(R.id.item8);
		tvItem8 = (TextView) findViewById(R.id.tvItem8);
		btnItem8 = (Button) findViewById(R.id.btnItem8);
		item9Holder = (RelativeLayout) findViewById(R.id.item9);
		tvItem9 = (TextView) findViewById(R.id.tvItem9);
		btnItem9 = (Button) findViewById(R.id.btnItem9);

		btnRemoveAll = (Button) findViewById(R.id.btnRemoveAll);
		btnCheckOut = (Button) findViewById(R.id.btnCheckOut);
	}

	private void setupActionBar() {
		// Resize the actionBarTitle text to fit long product names
		actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText("Cart");
		/**
		 * Clicking either the back button or the title on the action bar will
		 * bring you BACK to the home screen
		 */
		actionBarTitle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Launching Home Screen
				CartActivity.this.finish();
			}
		});
		// ActionBar Back button
		btnActionBarBack = (Button) findViewById(R.id.btnActionBarBack);
		// Listening Back button click
		btnActionBarBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Launching Home Screen
				CartActivity.this.finish();
			}
		});

	}

	private int getSelectedProduct(String passedVar) {
		int productID = 0;
		try {
			productID = Integer.parseInt(passedVar);
		} catch (NumberFormatException nfe) {
			System.out.println("Could not parse " + nfe);
		}

		return productID;
	}

	private void setupProductRetrieval() {
		// Get our list of products using productRetrieval
		try {
			products = new ProductRetrieval();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productQuantity = products.getProductInventory();
		descriptions = products.getProductDescriptions();
		prices = products.getProductPrices();
		imageURLS = products.getImageURL();
		productNames = products.getProductNames();
		// END OF RETRIEVING PRODUCT INFO
	}

}
