package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DirectionsActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directions_layout);

        TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
        actionBarTitle.setText(R.string.directions);

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

    }
}
