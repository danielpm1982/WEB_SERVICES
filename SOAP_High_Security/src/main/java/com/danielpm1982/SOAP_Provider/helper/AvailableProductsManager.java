package com.danielpm1982.SOAP_Provider.helper;
import java.util.Arrays;
import java.util.List;
import com.danielpm1982.customerorders.Product;

public class AvailableProductsManager{
	private static List<Product> availableProducts;
	static {
		Product p1 = createAndSetProduct("101", "Product101");
		Product p2 = createAndSetProduct("102", "Product102");
		Product p3 = createAndSetProduct("103", "Product103");
		Product p4 = createAndSetProduct("104", "Product104");
		Product p5 = createAndSetProduct("105", "Product105");
		Product p6 = createAndSetProduct("106", "Product106");
		Product p7 = createAndSetProduct("107", "Product107");
		Product p8 = createAndSetProduct("108", "Product108");
		Product p9 = createAndSetProduct("109", "Product109");
		availableProducts = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9);
	}
	private static Product createAndSetProduct(String productId, String description) {
		Product product = new Product();
		product.setId(productId);
		product.setDescription(description);
		return product;
	}
	public static List<Product> getAvailableProducts() {
		return availableProducts;
	}
}

/*
As, at this sample project, no database is used to manage the Products that could be ordered
from the Consumer to this Provider server, this helper class is used to generate sample products, 
which then can be retrieved, from the Consumer server, through the implemented CustomerOrdersPortType 
(CustomerOrdersWSImpl.class) getProducts operation, and later turned available to the clients of the
Consumer server, listing the possible Products that could be added at the requesting Orders... for example,
at a select HTML element at the Product request web page. Before forwarding to the Product request page,
the Consumer server Controller could update dynamically the Product list available at this Provider class. 
Only Products created at this class could be added to the Orders, and then sent through the SOAP Web Service.
*/
