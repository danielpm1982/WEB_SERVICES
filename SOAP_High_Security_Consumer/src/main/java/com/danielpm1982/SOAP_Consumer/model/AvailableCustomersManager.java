package com.danielpm1982.SOAP_Consumer.model;
import java.util.List;
import com.danielpm1982.customerorders.Customer;

public class AvailableCustomersManager{
	private static List<Customer> availableCustomersList;
	public static List<Customer> getAvailableCustomersList() {
		return availableCustomersList;
	}
	public static void setAvailableCustomersList(List<Customer> availableCustomersList) {
		AvailableCustomersManager.availableCustomersList = availableCustomersList;
	}
}

/*
This class simply acts as a DTO (dataTransferObject) class, for storing the available Customers
obtained from the Provider, set at this class availableCustomersList by the CustomersConfigureHelper
class. This class' availableCustomersList can then be retrieved from the Controller, for populating the
HTML select element options at the view.
*/
