package com.danielpm1982.SOAP_Provider.helper;
import java.util.Arrays;
import java.util.List;
import com.danielpm1982.customerorders.Customer;

public class AvailableCustomersManager{
	private static List<Customer> availableCustomers;
	static {
		Customer c1 = createAndSetCustomer(1, "Customer1");
		Customer c2 = createAndSetCustomer(2, "Customer2");
		Customer c3 = createAndSetCustomer(3, "Customer3");
		Customer c4 = createAndSetCustomer(4, "Customer4");
		Customer c5 = createAndSetCustomer(5, "Customer5");
		availableCustomers = Arrays.asList(c1, c2, c3, c4, c5);
	}
	private static Customer createAndSetCustomer(long customerId, String customerName) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		return customer;
	}
	public static List<Customer> getAvailableCustomers() {
		return availableCustomers;
	}
}

/*
As, at this sample project, no database is used to manage the Customers that could send Orders
from the Consumer to this Provider server, this helper class is used to generate sample Customers, 
which then can be retrieved, as a list, from the Consumer server, through the implemented 
CustomerOrdersPortType (CustomerOrdersWSImpl.class) getCustomers operation, and later turned 
available to the clients of the Consumer server, listing the possible Customers that could make the Orders... 
for example, at a select HTML element at the Product request web page. Before forwarding to the 
Product request page, the Consumer server Controller could update dynamically the Customers list available 
at this Provider class. Only Customers created at this class could request Orders, later sent through the SOAP Web Service.
*/
