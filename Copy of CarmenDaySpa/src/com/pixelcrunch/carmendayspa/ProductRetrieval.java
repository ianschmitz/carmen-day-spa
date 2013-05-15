package com.pixelcrunch.carmendayspa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductRetrieval {

	private static String carmanURL = "http://74.124.197.190/~carmen21/prod_display.php";

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

	public ProductRetrieval() throws IOException {

		// I have a feeling the issue has to do with threads
		//android.os.NetworkOnMainThreadException
		String out = new Scanner(new URL(carmanURL).openStream(), "UTF-8")
				.useDelimiter("\\A").next();

		List<String> lineContent = Arrays.asList(out.split(","));
		productNumbers.add(lineContent.get(0));
		productNames.add(lineContent.get(1));
		productPrices.add(lineContent.get(2));
		productInventory.add(lineContent.get(3));
		productDescriptions.add(lineContent.get(4));
		productImageURL.add(lineContent.get(5));
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
