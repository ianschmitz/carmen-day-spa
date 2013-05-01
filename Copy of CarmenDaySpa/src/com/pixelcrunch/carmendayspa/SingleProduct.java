package com.pixelcrunch.carmendayspa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleProduct extends Activity {

	ProductRetrieval products;

	String passedVar = null;
	private TextView passedView = null;

	String[] descriptions;
	String[] prices;
	String[] imageURLS;
	int productID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_product_layout);

		// Correctly name the page title
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.product);

		// Get our list of products
		products = new ProductRetrieval();
		descriptions = products.getProductDescriptions();
		prices = products.getProductPrices();
		imageURLS = products.getImageURLS();

		/**
		 * Clicking either the back button or the title on the action bar will
		 * bring you back to the home screen
		 */
		actionBarTitle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching Home Screen
				Intent i = new Intent(getApplicationContext(),
						ProductsActivity.class);
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
				Intent i = new Intent(getApplicationContext(),
						ProductsActivity.class);
				startActivity(i);
			}
		});

		// Get our passed Variable from productsActivity EXTRAS
		passedVar = getIntent().getStringExtra(ProductsActivity.ID_EXTRA);
		try {
			productID = Integer.parseInt(passedVar);
		} catch (NumberFormatException nfe) {
			System.out.println("Could not parse " + nfe);
		}

		TextView description = (TextView) findViewById(R.id.tvDescription);
		TextView price = (TextView) findViewById(R.id.tvPrice);

		description.setText(descriptions[productID]);
		price.setText(prices[productID]);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_product, menu);
		return true;
	}

}
