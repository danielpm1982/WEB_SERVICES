package com.danielpm1982.SOAP_WS1_Client.helper;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import com.danielpm1982.customerorders.CreateOrdersRequest;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetOrdersRequest;
import com.danielpm1982.customerorders.GetOrdersResponse;
import com.danielpm1982.customerorders.Order;
import com.danielpm1982.customerorders.Product;
import com.danielpm1982.soap_ws1.ws.CustomerOrdersWSImplService;

public class CustomerOrdersWSClientHelper {
	private static CustomerOrdersWSImplService service;
	private static CustomerOrdersPortType customerOrdersPortType;
	static {
		try {
			service = new CustomerOrdersWSImplService(new URL("http://localhost:8080/SOAP_WS1/api/customerOrdersService?wsdl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		customerOrdersPortType = service.getCustomerOrdersWSImplPort();
	}
	public static List<Order> getOrders(int customerId) {
		GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
		getOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		GetOrdersResponse getOrdersResponse = customerOrdersPortType.getOrders(getOrdersRequest);
		List<Order> orderList = getOrdersResponse.getOrder();
		return orderList;
	}
	public static Order createOrdersSample1() {
		Product product1 = new Product();
		product1.setId("60");
		product1.setDescription("product60");
		product1.setQuantity(BigInteger.valueOf(4));
		Product product2 = new Product();
		product2.setId("445");
		product2.setDescription("product445");
		product2.setQuantity(BigInteger.valueOf(9));
		return createOrder(1, 1, product1, product2);
	}
	public static Order createOrdersSample2() {
		Product product1 = new Product();
		product1.setId("650");
		product1.setDescription("product650");
		product1.setQuantity(BigInteger.valueOf(6));
		Product product2 = new Product();
		product2.setId("644");
		product2.setDescription("product644");
		product2.setQuantity(BigInteger.valueOf(1));
		Product product3 = new Product();
		product3.setId("1000");
		product3.setDescription("product1000");
		product3.setQuantity(BigInteger.valueOf(3));
		return createOrder(1, 2, product1, product2, product3);
	}
	public static Order createOrdersSample3() {
		Product product1 = new Product();
		product1.setId("10");
		product1.setDescription("product10");
		product1.setQuantity(BigInteger.valueOf(1));
		return createOrder(1, 3, product1);
	}
	private static Order createOrder(int customerId, int orderId, Product... products) {
		CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
		createOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		Order order = new Order();
		order.setId(BigInteger.valueOf(orderId));
		order.getProduct().addAll(Arrays.asList(products));
		createOrdersRequest.setOrder(order);
		customerOrdersPortType.createOrders(createOrdersRequest);
		return order;
	}
}

//This is a helper class, which directly deals with the WSImplService and PortType stub objects, and can
//be used at the Controller for accessing the webServices at the provider-side server (SOAP_WS1)
//from this consumer-side server (SOAP_WS1_Client).
