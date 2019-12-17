package com.danielpm1982.SOAP_Consumer.model;
import java.util.List;
import com.danielpm1982.customerorders.Product;

public class AvailableProductsManager{
	private static List<Product> availableProductsList;
	public static List<Product> getAvailableProductsList() {
		return availableProductsList;
	}
	public static Product getProductForId(String id) {
		Product product = availableProductsList.stream().filter(x->x.getId().equals(id)).findFirst().get();
		return product;
	}
	public static void setAvailableProductsList(List<Product> availableProductsList) {
		AvailableProductsManager.availableProductsList = availableProductsList;
	}
}

/*
This class simply acts as a DTO (dataTransferObject) class, for storing the available Products
obtained from the Provider, set at this class availableProductsList by the ProductsConfigureHelper
class. This class' availableProductsList can then be retrieved from the Controller, for populating the
HTML select element options at the view.
*/
