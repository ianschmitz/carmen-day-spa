package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BookingActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booking_layout);
		
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.booking);
	}
}
