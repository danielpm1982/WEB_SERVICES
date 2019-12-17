package com.danielpm1982.SOAP_Consumer;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.cxf.feature.Features;
import com.danielpm1982.SOAP_Consumer.helper.CustomerOrdersHelper;
import com.danielpm1982.SOAP_Consumer.helper.SOAPSecurityHelper;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetOrdersRequest;
import com.danielpm1982.customerorders.GetOrdersResponse;
import com.danielpm1982.customerorders.Order;
import com.danielpm1982.customerorders.Product;
import com.danielpm1982.soap_provider.ws.CustomerOrdersWSImplService;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class SOAP_Consumer_Console {
	private static CustomerOrdersWSImplService service;
	private static CustomerOrdersPortType customerOrdersPortType;
	public static void main(String[] args) throws MalformedURLException {
		//getting the implemented Port from the Service for using its operations according to the wsdl at the client:
		service = new CustomerOrdersWSImplService(new URL("http://localhost:8080/soap/api/customerOrdersService?wsdl"));
		customerOrdersPortType = service.getCustomerOrdersWSImplPort();
		SOAPSecurityHelper.configureSecurity(customerOrdersPortType);
		//getting and showing orderList items for customerId=1:
		printOrders(1);
		System.out.println();
		//adding and showing new orders for customerId=1
		CustomerOrdersHelper.createOrdersSample1();
		CustomerOrdersHelper.createOrdersSample2();
		CustomerOrdersHelper.createOrdersSample3();
		System.out.println();
		printOrders(1);
		System.out.println();
	}
	private static String getProductListString(List<Product> productList) {
		return productList.stream().map(x->"Product: id: "+x.getId()+" description: "+x.getDescription()+" quantity: "+x.getQuantity()).collect(Collectors.toList()).toString();
	}
	private static void printOrderListString(List<Order> orderList) {
		orderList.forEach(x->System.out.println("Order: id: "+x.getId()+" "+getProductListString(x.getProduct())));
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
}

//This is a console testing class. Use the other main class for testing of the project as a whole, including
//the web user interface.
