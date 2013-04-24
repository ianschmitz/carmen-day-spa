package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_layout);

		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.about);

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

		TextView textView = (TextView) findViewById(R.id.aboutParagraph);
		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/Chantelli_Antiqua.ttf");
		textView.setTypeface(typeFace);
	}
}
