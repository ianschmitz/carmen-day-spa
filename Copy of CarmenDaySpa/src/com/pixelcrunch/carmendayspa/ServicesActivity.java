package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ServicesActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.services_layout);
		
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.services);

	}
}
