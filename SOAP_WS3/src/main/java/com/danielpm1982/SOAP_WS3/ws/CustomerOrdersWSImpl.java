package com.danielpm1982.SOAP_WS3.ws;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cxf.feature.Features;
import com.danielpm1982.customerorders.CreateOrdersRequest;
import com.danielpm1982.customerorders.CreateOrdersResponse;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetOrdersRequest;
import com.danielpm1982.customerorders.GetOrdersResponse;
import com.danielpm1982.customerorders.Order;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWSImpl implements CustomerOrdersPortType {
	Map<BigInteger, List<Order>> customerOrdersMap; //a map for each customerId with a list of all orders, each order with a list of all Products ordered by that client at a certain time. This structure simulates a DB.
	int currentId; //this field simulates an autoincrement PK for each client at the map (simulated DB) above.
	public CustomerOrdersWSImpl() {
		init();
	}
	private void init(){ //initiating the customerOdersMap and an empty orderList (clientId, ordersList) for customerId=1. For ++clientId, add a list of Orders, with each order containing a list of products. The orders will be passed from the client app through the createOrders method below.
		if(customerOrdersMap==null) {
			customerOrdersMap = new HashMap<>();
		}
		List<Order> orderList = new ArrayList<>();
		customerOrdersMap.put(BigInteger.valueOf(++currentId), orderList);
	}
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) { //getting the List<Order> for the clientId from the map, using the request received. Creating a GetOrdersResponse, with a default empty orders list, and adding all the Order values from the orderList of the map to the response list, returning, thus, all the orders for that client available at the map, which here simulates a DB. 
		BigInteger customerId = request.getCustomerId();
		List<Order> orderList = customerOrdersMap.get(customerId);
		GetOrdersResponse getOrdersResponse = new GetOrdersResponse();
		getOrdersResponse.getOrder().addAll(orderList);
		return getOrdersResponse;
	}
	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) { //getting the customerId and the Order to be added (to the orderList of the map) using the request received. With the customerId, getting the orderList, already existent at the map (or DB), and adding the adding order. Returning true if no exception is thrown.
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		List<Order> orderList = customerOrdersMap.get(customerId);
		orderList.add(order);
		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
		createOrdersResponse.setResult(true);
		return createOrdersResponse;
	}
}

//This is the PortType implementation that will be used at the consumer server side for accessing the webServices.
