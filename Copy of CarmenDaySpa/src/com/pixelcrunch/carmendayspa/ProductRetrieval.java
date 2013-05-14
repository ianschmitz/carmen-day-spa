package com.pixelcrunch.carmendayspa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRetrieval {

	private List<String> items;

	private String productPageString;

	private List<String> productInformation;

	private List<String> productNames = new ArrayList<String>();

	private List<String> productPrices = new ArrayList<String>();

	private List<String> productInventory = new ArrayList<String>();

	private List<String> productNumbers = new ArrayList<String>();

	// Array of Strings containing product image URLS
	private List<String> productImageURL = new ArrayList<String>();

	// Array of Strings containing product Descriptions
	private List<String> productDescriptions = new ArrayList<String>();

	public ProductRetrieval() {
		BufferedReader in = null;

		// Attempt to open stream to website specified as CL argument, catches
		// exceptions
		try {

			// Create a URL object using 1st CL argument
			URL carmen = new URL(
					"http://74.124.197.190/~carmen21/prod_display.php");

			// Hold read data
			// BREAKS APP
			in = new BufferedReader(new InputStreamReader(carmen.openStream()));

		} catch (MalformedURLException e) {

			System.err.println("Unable to find URL specified");
			System.exit(-1);

		} catch (IOException e) {

			System.err.println("IO Exception - Can't find page at URL");
			System.exit(-1);

		}

		// If passed the first try, try to read lines from the URL's HTML
		try {

			String inputLine;

			// Put each line into the array
			while ((inputLine = in.readLine()) != null) {
				productPageString += inputLine;

			}

			in.close();

		} catch (IOException ex) {
			System.err.println("Error reading from website");
		}

		items = Arrays.asList(productPageString.split("\\s*,\\s*"));

		int offset = 0;

		while (offset < items.size()) {

			productNumbers.add(items.get(0 + offset));
			productNames.add(items.get(1 + offset));
			productPrices.add(items.get(2 + offset));
			productInventory.add(items.get(3 + offset));
			productDescriptions.add(items.get(4 + offset));
			productImageURL.add(items.get(5 + offset));

			offset += 5;
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
}
