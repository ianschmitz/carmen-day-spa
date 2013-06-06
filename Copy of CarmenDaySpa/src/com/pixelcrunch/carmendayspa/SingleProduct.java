package com.pixelcrunch.carmendayspa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SingleProduct extends Activity {
	private ProductRetrieval products;
	public ProductImageLoader imageLoader;
	String passedVar = null;
	private TextView passedView = null;
	SharedPreferences prefs;
	TextView description;
	TextView actionBarTitle;
	Button btnActionBarBack;
	TextView price;
	ImageView img;
	Spinner spinQuant;
	ImageButton btnCart;
	TextView tvOutOfStock;
	List<String> descriptions;
	List<String> prices;
	List<String> imageURLS;
	List<String> productNames;
	List<String> productQuantity;
	int productID;
	int selectedQuant = 0;

	boolean isEmpty;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_product_layout);

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

		/**
		 * Get sharedPreferences for saving to cart
		 */
		prefs = this.getSharedPreferences("carmen_cart", Context.MODE_PRIVATE);

		setupActionBar();

		setupProductRetrieval();

		imageLoader = new ProductImageLoader(getApplicationContext());

		getSelectedProduct();

		// init sets up the view, Ensure productRetrieval and
		// getSelectedProduct is done first
		init();

		// when quantity spinner is changed
		spinQuant
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						Object item = parent.getItemAtPosition(pos);
						selectedQuant = Integer.parseInt(item.toString());
					}

					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		// On Cart Button Click
		btnCart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				saveToCart();
				SingleProduct.this.finish();
			}
		});

	}

	private void saveToCart() {
		Editor editor = prefs.edit();

		editor.putInt(String.valueOf(productID), selectedQuant);

		editor.commit(); // commit changes
	}

	// save the value the user selects under quantity
	public void onItemSelected(AdapterView<?> main, View view, int position,
			long Id) {

	}

	private void init() {
		description = (TextView) findViewById(R.id.tvDescription);
		price = (TextView) findViewById(R.id.tvPrice);
		img = (ImageView) findViewById(R.id.imgProduct);
		spinQuant = (Spinner) findViewById(R.id.spinQuantity);
		btnCart = (ImageButton) findViewById(R.id.btnCart);
		tvOutOfStock = (TextView) findViewById(R.id.tvOutOfStock);

		// load our Quantity spinner with a max of how ever many are left of
		// that product
		int quant = Integer.parseInt(productQuantity.get(productID));
		if (quant == 0) {
			spinQuant.setVisibility(View.GONE);
			btnCart.setVisibility(View.GONE);
			tvOutOfStock.setVisibility(View.VISIBLE);
		} else {
			List<String> quantAmounts = new ArrayList<String>();
			for (int i = 0; i <= quant; i++) {
				quantAmounts.add(String.valueOf(i));
			}
			// Creating adapter for spinner
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, quantAmounts);
			// Drop down layout style - list view with radio button
			dataAdapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			// attaching data adapter to spinner
			spinQuant.setAdapter(dataAdapter);
		}

		description.setText(descriptions.get(productID));
		price.setText("$" + prices.get(productID));
		imageLoader.DisplayImage(imageURLS.get(productID), img);
		actionBarTitle.setText(productNames.get(productID));
	}

	private void setupActionBar() {
		// Resize the actionBarTitle text to fit long product names
		actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setTextSize(16);
		/**
		 * Clicking either the back button or the title on the action bar will
		 * bring you BACK to the home screen
		 */
		actionBarTitle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Launching Home Screen
				SingleProduct.this.finish();
			}
		});
		// ActionBar Back button
		btnActionBarBack = (Button) findViewById(R.id.btnActionBarBack);
		// Listening Back button click
		btnActionBarBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Launching Home Screen
				SingleProduct.this.finish();
			}
		});

	}

	private void getSelectedProduct() {
		// Get our passed Variable from productsActivity EXTRAS
		passedVar = getIntent().getStringExtra(ProductsActivity.ID_EXTRA);
		try {
			productID = Integer.parseInt(passedVar);
		} catch (NumberFormatException nfe) {
			System.out.println("Could not parse " + nfe);
		}
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
