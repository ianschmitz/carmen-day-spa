package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DirectionsActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directions_layout);
		
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.directions);
	}
}
