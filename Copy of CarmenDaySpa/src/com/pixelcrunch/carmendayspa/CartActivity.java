package com.pixelcrunch.carmendayspa;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
	TextView tvSubTotal;

	Button btnRemoveAll;
	Button btnCheckOut;

	List<String> descriptions;
	List<String> prices;
	List<String> imageURLS;
	List<String> productNames;
	List<String> productQuantity;

	float prod1Total;
	float prod2Total;
	float prod3Total;
	float prod4Total;
	float prod5Total;
	float prod6Total;
	float prod7Total;
	float prod8Total;
	float prod9Total;

	int subtotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart_layout);

		setupActionBar();

		setupProductRetrieval();

		init();

		btnItem1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("0");
				item1Holder.setVisibility(View.GONE);

				subtotal -= prod1Total;
				tvSubTotal.setText("$" + subtotal);

			}
		});

		btnItem2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("1");
				item2Holder.setVisibility(View.GONE);

				subtotal -= prod2Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("2");
				item3Holder.setVisibility(View.GONE);

				subtotal -= prod3Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("3");
				item4Holder.setVisibility(View.GONE);

				subtotal -= prod4Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem5.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("4");
				item5Holder.setVisibility(View.GONE);

				subtotal -= prod5Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem6.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("5");
				item6Holder.setVisibility(View.GONE);

				subtotal -= prod6Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem7.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("6");
				item7Holder.setVisibility(View.GONE);

				subtotal -= prod7Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem8.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("7");
				item8Holder.setVisibility(View.GONE);

				subtotal -= prod8Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnItem9.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				removeItem("8");
				item9Holder.setVisibility(View.GONE);

				subtotal -= prod9Total;
				tvSubTotal.setText("$" + subtotal);
			}
		});

		btnRemoveAll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Editor editor = prefs.edit();

				editor.clear();

				editor.commit(); // commit changes

				CartActivity.this.finish();

			}
		});

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
		tvSubTotal = (TextView) findViewById(R.id.lblSubtotal);

		btnRemoveAll = (Button) findViewById(R.id.btnRemoveAll);
		btnCheckOut = (Button) findViewById(R.id.btnCheckOut);

		/**
		 * Get sharedPreferences for saving to cart
		 */
		prefs = this.getSharedPreferences("carmen_cart", Context.MODE_PRIVATE);
		Map<String, ?> keys = prefs.getAll();

		for (Map.Entry<String, ?> entry : keys.entrySet()) {
			int productID = getSelectedProduct(entry.getKey());
			String productString = "";
			String prodName = productNames.get(productID);
			String prodQuantity = String.valueOf(entry.getValue());
			String prodPrice = prices.get(productID);

			float productTotal = Float.parseFloat(prodQuantity)
					* Float.parseFloat(prodPrice);
			subtotal += productTotal;

			productString += prodName + " - " + prodQuantity + "@" + prodPrice;

			switch (productID) {
			case 0:
				tvItem1.setText(productString);
				item1Holder.setVisibility(View.VISIBLE);
				prod1Total = productTotal;
				break;
			case 1:
				tvItem2.setText(productString);
				item2Holder.setVisibility(View.VISIBLE);
				prod2Total = productTotal;
				break;
			case 2:
				tvItem3.setText(productString);
				item3Holder.setVisibility(View.VISIBLE);
				prod3Total = productTotal;
				break;
			case 3:
				tvItem4.setText(productString);
				item4Holder.setVisibility(View.VISIBLE);
				prod4Total = productTotal;
				break;
			case 4:
				tvItem5.setText(productString);
				item5Holder.setVisibility(View.VISIBLE);
				prod5Total = productTotal;
				break;
			case 5:
				tvItem6.setText(productString);
				item6Holder.setVisibility(View.VISIBLE);
				prod6Total = productTotal;
				break;
			case 6:
				tvItem7.setText(productString);
				item7Holder.setVisibility(View.VISIBLE);
				prod7Total = productTotal;
				break;
			case 7:
				tvItem8.setText(productString);
				item8Holder.setVisibility(View.VISIBLE);
				prod8Total = productTotal;
				break;
			case 8:
				tvItem9.setText(productString);
				item9Holder.setVisibility(View.VISIBLE);
				prod9Total = productTotal;
				break;
			}
		}

		tvSubTotal.setText("$" + subtotal);

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

	private void removeItem(String itemKey) {
		Editor editor = prefs.edit();

		editor.remove(itemKey);

		editor.commit(); // commit changes
	}
}
