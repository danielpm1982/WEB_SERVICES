package com.danielpm1982.SOAP_WS1_Client;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.danielpm1982.customerorders.CreateOrdersRequest;
import com.danielpm1982.customerorders.CreateOrdersResponse;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetOrdersRequest;
import com.danielpm1982.customerorders.GetOrdersResponse;
import com.danielpm1982.customerorders.Order;
import com.danielpm1982.customerorders.Product;
import com.danielpm1982.soap_ws1.ws.CustomerOrdersWSImplService;

public class CustomerOrdersWSClientConsole {
	private static CustomerOrdersWSImplService service;
	private static CustomerOrdersPortType customerOrdersPortType;
	public static void main(String[] args) throws MalformedURLException {
		//getting the implemented Port from the Service for using its operations according to the wsdl at the client:
		service = new CustomerOrdersWSImplService(new URL("http://localhost:8080/SOAP_WS1/api/customerOrdersService?wsdl"));
		customerOrdersPortType = service.getCustomerOrdersWSImplPort();
		//getting and showing orderList items for customerId=1:
		printOrders(1);
		System.out.println();
		//adding and showing new orders for customerId=1
		createOrdersSample1();
		createOrdersSample2();
		createOrdersSample3();
		System.out.println();
		printOrders(1);
		System.out.println();
	}
	private static void printOrders(int customerId) {
		GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
		getOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		GetOrdersResponse getOrdersResponse = customerOrdersPortType.getOrders(getOrdersRequest);
		List<Order> orderList = getOrdersResponse.getOrder();
		System.out.println("OrderList for customerId="+getOrdersRequest.getCustomerId()+":");
		printOrderListString(orderList);
		System.out.println(orderList.size()+" order(s) found.");
	}
	private static String getProductListString(List<Product> productList) {
		return productList.stream().map(x->"Product: id: "+x.getId()+" description: "+x.getDescription()+" quantity: "+x.getQuantity()).collect(Collectors.toList()).toString();
	}
	private static void printOrderListString(List<Order> orderList) {
		orderList.forEach(x->System.out.println("Order: id: "+x.getId()+" "+getProductListString(x.getProduct())));
	}
	private static void createOrdersSample1() {
		Product product1 = new Product();
		product1.setId("60");
		product1.setDescription("product60");
		product1.setQuantity(BigInteger.valueOf(4));
		Product product2 = new Product();
		product2.setId("445");
		product2.setDescription("product445");
		product2.setQuantity(BigInteger.valueOf(9));
		createOrder(1, 1, product1, product2);
	}
	private static void createOrdersSample2() {
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
		createOrder(1, 2, product1, product2, product3);
	}
	private static void createOrdersSample3() {
		Product product1 = new Product();
		product1.setId("10");
		product1.setDescription("product10");
		product1.setQuantity(BigInteger.valueOf(1));
		createOrder(1, 3, product1);
	}
	private static void createOrder(int customerId, int orderId, Product... products) {
		CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
		createOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		Order order = new Order();
		order.setId(BigInteger.valueOf(orderId));
		order.getProduct().addAll(Arrays.asList(products));
		createOrdersRequest.setOrder(order);
		CreateOrdersResponse createOrdersResponse = customerOrdersPortType.createOrders(createOrdersRequest);
		System.out.println(createOrdersResponse.isResult()?"Added successfully!":"Adding failed!");
	}
}

//this is a console testing class. Use the other main class for testing of the project as a whole, including
//the web user interface.
