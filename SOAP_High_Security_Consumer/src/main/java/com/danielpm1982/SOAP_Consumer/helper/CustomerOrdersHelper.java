package com.danielpm1982.SOAP_Consumer.helper;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import org.apache.cxf.feature.Features;
import com.danielpm1982.customerorders.CreateOrdersRequest;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetOrdersRequest;
import com.danielpm1982.customerorders.GetOrdersResponse;
import com.danielpm1982.customerorders.Order;
import com.danielpm1982.customerorders.Product;
import com.danielpm1982.soap_provider.ws.CustomerOrdersWSImplService;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersHelper {
	private static CustomerOrdersWSImplService service;
	private static CustomerOrdersPortType customerOrdersPortType;
	static {
		try {
			service = new CustomerOrdersWSImplService(new URL("http://localhost:8080/soap/api/customerOrdersService?wsdl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		customerOrdersPortType = service.getCustomerOrdersWSImplPort();
		SOAPSecurityHelper.configureSecurity(customerOrdersPortType);
	}
	public static List<Order> getOrders(int customerId) {
		GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
		getOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		GetOrdersResponse getOrdersResponse = customerOrdersPortType.getOrders(getOrdersRequest);
		List<Order> orderList = getOrdersResponse.getOrder();
		return orderList;
	}
	public static Order createOrder(int customerId, Product... products) {
		CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
		createOrdersRequest.setCustomerId(BigInteger.valueOf(customerId));
		Order order = new Order();
		long dateTimeInMillis = LocalDateTime.now().toInstant(ZoneOffset.ofHours(-3)).toEpochMilli();
		order.setId(BigInteger.valueOf(dateTimeInMillis));
		order.getProduct().addAll(Arrays.asList(products));
		createOrdersRequest.setOrder(order);
		customerOrdersPortType.createOrders(createOrdersRequest);
		return order;
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
		return createOrder(1, product1, product2);
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
		return createOrder(1, product1, product2, product3);
	}
	public static Order createOrdersSample3() {
		Product product1 = new Product();
		product1.setId("10");
		product1.setDescription("product10");
		product1.setQuantity(BigInteger.valueOf(1));
		return createOrder(1, product1);
	}
}

/*
This class is used by the Controller to access the implemented PortType stub, apply the security 
through the SOAPSecurityHelper and UTPasswordCallback classes, and call the WSDL operations getOrders 
and create orders, communicating with the Provider, sending requests and receiving responses.
Additionally, 3 public methods were added in order to be called by Console testing class and abstract
from that class the creation of these sample Orders... these methods, though, are not used or needed
for the Web view or for the Controller. Only the createOrder and getOrder methods.
*/
