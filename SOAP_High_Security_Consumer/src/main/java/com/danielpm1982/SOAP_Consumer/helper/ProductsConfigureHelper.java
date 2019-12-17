package com.danielpm1982.SOAP_Consumer.helper;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.cxf.feature.Features;
import com.danielpm1982.SOAP_Consumer.model.AvailableProductsManager;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetProductsRequest;
import com.danielpm1982.customerorders.GetProductsResponse;
import com.danielpm1982.soap_provider.ws.CustomerOrdersWSImplService;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class ProductsConfigureHelper {
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
	public static void configureProducts() {
		GetProductsResponse getProductsResponse = customerOrdersPortType.getProducts(new GetProductsRequest());
		AvailableProductsManager.setAvailableProductsList(getProductsResponse.getProduct());
	}
}

/*
This class uses the SOAP Web Service to get, from the Provider, the list of Products available for the
Consumer server clients to select for an Order request.
After retrieving the Products list, it is set as the availableProductsList at the AvailableProductsManager,
from where the Products retrieved from the Provider, and now saved at the Consumer, can then be sent to 
populate the view HTML select options.  
*/
