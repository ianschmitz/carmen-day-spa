package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_layout);

		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.contact);

		/**
		 * Display Rating Update in a Toast
		 */

		final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
		ratingbar.setStepSize((float) 1); //
		ratingbar.setRating((float) 5); // set rating which u want to display

		ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Toast.makeText(ContactActivity.this, "New Rating: " + rating,
						Toast.LENGTH_SHORT).show();
			}
		});

		/**
		 * 
		 */

	}

}
