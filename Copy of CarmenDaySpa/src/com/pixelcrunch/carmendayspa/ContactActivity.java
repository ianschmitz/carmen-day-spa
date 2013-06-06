package com.pixelcrunch.carmendayspa;

import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends Activity {
	SharedPreferences prefs;
	boolean isEmpty;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_layout);

		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.contactTitle);

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

		/**
		 * Creating submit button instance
		 * */

		Button btn_feedback = (Button) findViewById(R.id.btnSubmitFeedback);

		// Set on click for feedback button, launching e-mail service
		btn_feedback.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				// Pull info from form fields
				EditText feedbackField = (EditText) findViewById(R.id.etFeedback);
				EditText firstName = (EditText) findViewById(R.id.etContactFirst);
				EditText lastName = (EditText) findViewById(R.id.etContactLast);
				String messageBody = feedbackField.getText().toString() + "\n"
						+ "\n" + firstName.getText().toString() + " "
						+ lastName.getText().toString();

				String subjectString;
				subjectString = "Customer Feedback";

				// Launching email
				Uri uri = Uri.parse("mailto:ryanfrrll4@gmail.com");

				Intent bookingEmail = new Intent(Intent.ACTION_SENDTO, uri);

				bookingEmail.putExtra(Intent.EXTRA_SUBJECT, subjectString);

				bookingEmail.putExtra(Intent.EXTRA_TEXT, messageBody);

				startActivity(bookingEmail);
			}
		});

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
