package com.pixelcrunch.carmendayspa;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ProductRetrieval {

	private static String carmanURL = "http://74.124.197.190/~carmen21/prod_display.php";
	private List<String> productNames = new ArrayList<String>();
	private List<String> productPrices = new ArrayList<String>();
	private List<String> productInventory = new ArrayList<String>();
	private List<String> productNumbers = new ArrayList<String>();
	// Array of Strings containing product image URLS
	private List<String> productImageURL = new ArrayList<String>();
	// Array of Strings containing product Descriptions
	private List<String> productDescriptions = new ArrayList<String>();
	Context thisActivity;

	public ProductRetrieval() throws IOException {
		try {
			new FetchURLContent().execute().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getProductNames() {

		return productNames;
	}

	public List<String> getImageURL() {

		return productImageURL;
	}

	public List<String> getProductNumbers() {

		return productNumbers;
	}

	public List<String> getProductInventory() {

		return productInventory;
	}

	public List<String> getProductDescriptions() {

		return productDescriptions;
	}

	public List<String> getProductPrices() {
		return productPrices;
	}

	private class FetchURLContent extends AsyncTask<Void, Void, Void> {

		protected Void doInBackground(Void... Void) {
			String out = null;
			try {
				out = new Scanner(new URL(carmanURL).openStream(), "UTF-8")
						.useDelimiter("\\A").next();
			} catch (IOException e) {
				return null;
			}

			List<String> lineContent = Arrays.asList(out.split(","));
			int offset = 0;
			for (int i = 0; i < lineContent.size() - 1; i += 6) {
				productNumbers.add(lineContent.get(offset + 0));
				productNames.add(lineContent.get(offset + 1));
				productPrices.add(lineContent.get(offset + 2));
				productInventory.add(lineContent.get(offset + 3));
				productDescriptions.add(lineContent.get(offset + 4));
				productImageURL.add(lineContent.get(offset + 5));

				offset += 6;
			}
			return null;
		}

	}
}
