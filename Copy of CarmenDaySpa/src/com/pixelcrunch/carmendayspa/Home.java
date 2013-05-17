package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);

		/**
		 * Make the action bar text and back button invisible and unclickable
		 */
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setVisibility(View.GONE);

		Button actionBarBack = (Button) findViewById(R.id.btnActionBarBack);
		actionBarBack.setVisibility(View.GONE);

		/**
		 * Creating all buttons instances
		 * */
		// Dashboard Services button
		Button btn_services = (Button) findViewById(R.id.btn_services);

		// Dashboard Products button
		Button btn_products = (Button) findViewById(R.id.btn_products);

		// Dashboard Booking button
		Button btn_booking = (Button) findViewById(R.id.btn_booking);

		// Dashboard Directions button
		Button btn_directions = (Button) findViewById(R.id.btn_directions);

		// Dashboard Contact button
		Button btn_contact = (Button) findViewById(R.id.btn_contact);

		// Dashboard About button
		Button btn_about = (Button) findViewById(R.id.btn_about);

		/**
		 * Handling all button click events
		 * */

		// Listening to News Feed button click
		btn_services.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						ServicesActivity.class);
				startActivity(i);
			}
		});

		// Listening Friends button click
		btn_products.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						ProductsActivity.class);
				startActivity(i);
			}
		});

		// Listening Messages button click
		btn_booking.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						BookingActivity.class);
				startActivity(i);
			}
		});

		// Listening to Places button click
		btn_directions.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						DirectionsActivity.class);
				startActivity(i);
			}
		});

		// Listening to Events button click
		btn_contact.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						ContactActivity.class);
				startActivity(i);
			}
		});

		// Listening to Photos button click
		btn_about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						AboutActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
