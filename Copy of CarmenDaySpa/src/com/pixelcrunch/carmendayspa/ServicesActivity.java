package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServicesActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.services_layout);

		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.services);

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
		 * Controls the accordion buttons.
		 */
		Button btnBody = (Button) findViewById(R.id.btnBody);
		Button btnFace = (Button) findViewById(R.id.btnFace);
		Button btnHandsFeet = (Button) findViewById(R.id.btnHandsFeet);
		Button btnHairRemoval = (Button) findViewById(R.id.btnHairRemoval);
		Button btnSpecialTouches = (Button) findViewById(R.id.btnSpecialTouches);

		View panelBody = findViewById(R.id.panelBody);
		panelBody.setVisibility(View.GONE);

		View panelFace = findViewById(R.id.panelFace);
		panelFace.setVisibility(View.GONE);

		View panelHandsFeet = findViewById(R.id.panelHandsFeet);
		panelHandsFeet.setVisibility(View.GONE);

		View panelHairRemoval = findViewById(R.id.panelHairRemoval);
		panelHairRemoval.setVisibility(View.GONE);

		View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
		panelSpecialTouches.setVisibility(View.GONE);

		btnBody.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				View panelBody = findViewById(R.id.panelBody);
				panelBody.setVisibility(View.VISIBLE);

				View panelFace = findViewById(R.id.panelFace);
				panelFace.setVisibility(View.GONE);

				View panelHandsFeet = findViewById(R.id.panelHandsFeet);
				panelHandsFeet.setVisibility(View.GONE);

				View panelHairRemoval = findViewById(R.id.panelHairRemoval);
				panelHairRemoval.setVisibility(View.GONE);

				View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
				panelSpecialTouches.setVisibility(View.GONE);

			}
		});

		btnFace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				View panelBody = findViewById(R.id.panelBody);
				panelBody.setVisibility(View.GONE);

				View panelFace = findViewById(R.id.panelFace);
				panelFace.setVisibility(View.VISIBLE);

				View panelHandsFeet = findViewById(R.id.panelHandsFeet);
				panelHandsFeet.setVisibility(View.GONE);

				View panelHairRemoval = findViewById(R.id.panelHairRemoval);
				panelHairRemoval.setVisibility(View.GONE);

				View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
				panelSpecialTouches.setVisibility(View.GONE);

			}
		});

		btnHandsFeet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				View panelBody = findViewById(R.id.panelBody);
				panelBody.setVisibility(View.GONE);

				View panelFace = findViewById(R.id.panelFace);
				panelFace.setVisibility(View.GONE);

				View panelHandsFeet = findViewById(R.id.panelHandsFeet);
				panelHandsFeet.setVisibility(View.VISIBLE);

				View panelHairRemoval = findViewById(R.id.panelHairRemoval);
				panelHairRemoval.setVisibility(View.GONE);

				View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
				panelSpecialTouches.setVisibility(View.GONE);

			}
		});

		btnHairRemoval.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				View panelBody = findViewById(R.id.panelBody);
				panelBody.setVisibility(View.GONE);

				View panelFace = findViewById(R.id.panelFace);
				panelFace.setVisibility(View.GONE);

				View panelHandsFeet = findViewById(R.id.panelHandsFeet);
				panelHandsFeet.setVisibility(View.GONE);

				View panelHairRemoval = findViewById(R.id.panelHairRemoval);
				panelHairRemoval.setVisibility(View.VISIBLE);

				View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
				panelSpecialTouches.setVisibility(View.GONE);

			}
		});

		btnSpecialTouches.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				View panelBody = findViewById(R.id.panelBody);
				panelBody.setVisibility(View.GONE);

				View panelFace = findViewById(R.id.panelFace);
				panelFace.setVisibility(View.GONE);

				View panelHandsFeet = findViewById(R.id.panelHandsFeet);
				panelHandsFeet.setVisibility(View.GONE);

				View panelHairRemoval = findViewById(R.id.panelHairRemoval);
				panelHairRemoval.setVisibility(View.GONE);

				View panelSpecialTouches = findViewById(R.id.panelSpecialTouches);
				panelSpecialTouches.setVisibility(View.VISIBLE);

			}
		});

	}
}
