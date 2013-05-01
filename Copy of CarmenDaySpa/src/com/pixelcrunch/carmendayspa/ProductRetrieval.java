package com.pixelcrunch.carmendayspa;

public class ProductRetrieval {

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
	// Array of Strings containing product Descriptions
	private String[] productDescriptions = {
			"Stick it in your ear",
			"Great for a shift on the corner",
			"Smell like a New York cabbie",
			"is it an oven mitt?",
			"Stick it in your nose",
			"smashbox... uh oh",
			"painting things... now for humans",
			"NARS, creativity is not our forte",
			"Spray it in your eye",
			"A cool item that will entice a ton of people to buy this insane product.",
			"Stick it in your foot", "Skin, now racially diverse",
			"torture tools with a free leather bag", "Stick it in your toe",
			"pencil... now for humans", };

	// Array of Strings containing product Prices
	private String[] productPrices = { "42.67", "16.52", "1.99", "199.99",
			"75.56", "69.54", "75.14", "924.55", "942.11", "35.64", "78.36",
			"41.39", "83.26", "8.69", "47.33", };

	public ProductRetrieval() {
	}

	public String[] getImageURLS() {
		return productImageURL;
	}

	public String[] getProductDescriptions() {
		return productDescriptions;
	}

	public String[] getProductPrices() {
		return productPrices;
	}
}
