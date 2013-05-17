package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
        actionBarTitle.setText(R.string.contactTitle);

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

    }

}
