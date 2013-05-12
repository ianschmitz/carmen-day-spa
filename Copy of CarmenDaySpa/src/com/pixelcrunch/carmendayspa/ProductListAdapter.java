package com.pixelcrunch.carmendayspa;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductListAdapter extends BaseAdapter {

	private Activity activity;
	private List<String> imageURLS;
	private List<String> productDescriptions;
	private List<String> productPrices;
	private static LayoutInflater inflater = null;
	public ProductImageLoader imageLoader;

	// Constructor *Add arguments for Array-Cost and Array-ProductDescription*
	public ProductListAdapter(Activity a, List<String> productImageURL,
			List<String> productDescriptions2, List<String> productPrices2) {
		activity = a;
		imageURLS = productImageURL;
		productDescriptions = productDescriptions2;
		productPrices = productPrices2;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ProductImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return imageURLS.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.product_item, null);

		TextView txtDescription = (TextView) vi.findViewById(R.id.text);
		TextView txtPrice = (TextView) vi.findViewById(R.id.textPrice);
		ImageView image = (ImageView) vi.findViewById(R.id.image);
		// This is the product description, change to the
		// array-ProductDescription
		txtDescription.setText(productDescriptions.get(position));
		// This is the product price, change to the array-ProductPrice
		txtPrice.setText("$" + productPrices.get(position));
		// This is the product Image, calls image loader to create the image
		imageLoader.DisplayImage(imageURLS.get(position), image);
		return vi;
	}
}