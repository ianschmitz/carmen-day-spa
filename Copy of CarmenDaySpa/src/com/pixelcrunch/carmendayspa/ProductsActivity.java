package com.pixelcrunch.carmendayspa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProductsActivity extends Activity {

	ListView list;
	ProductListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.products_layout);
		// Creates the list where each item corresponds to a ListAdapter Item
		list = (ListView) findViewById(R.id.list);
		adapter = new ProductListAdapter(this, productImageURL);
		list.setAdapter(adapter);
		
		TextView actionBarTitle = (TextView) findViewById(R.id.tvActionBarTitle);
		actionBarTitle.setText(R.string.products);

		// Creates the More Button
		Button b = (Button) findViewById(R.id.btnActionBarBack);
		b.setOnClickListener(listener);
	}

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

	// Implement Code for the more button
	public OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {

			// adapter.imageLoader.clearCache();
			// adapter.notifyDataSetChanged();
		}
	};

	// Array of Strings containing product image URLS
	private String[] productImageURL = {
			"http://www.sephora.com/productimages/sku/s1494251-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1493873-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1508274-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1514926-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1502855-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1497007-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1473727-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1478254-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1530013-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1498302-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1494236-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1487248-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1489665-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1500859-main-grid.jpg",
			"http://www.sephora.com/productimages/sku/s1498682-main-grid.jpg", }; 
}