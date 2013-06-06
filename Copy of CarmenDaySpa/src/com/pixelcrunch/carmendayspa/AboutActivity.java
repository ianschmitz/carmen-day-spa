package com.pixelcrunch.carmendayspa;

import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends Activity {
	SharedPreferences prefs;
	boolean isEmpty;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_layout);

		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.about);

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

		TextView textView = (TextView) findViewById(R.id.bodyParagraph);
		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/Chantelli_Antiqua.ttf");
		textView.setTypeface(typeFace);
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
