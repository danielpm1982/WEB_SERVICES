package com.danielpm1982.SOAP_Consumer.helper;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.cxf.feature.Features;
import com.danielpm1982.SOAP_Consumer.model.AvailableCustomersManager;
import com.danielpm1982.customerorders.CustomerOrdersPortType;
import com.danielpm1982.customerorders.GetCustomersRequest;
import com.danielpm1982.customerorders.GetCustomersResponse;
import com.danielpm1982.soap_provider.ws.CustomerOrdersWSImplService;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomersConfigureHelper {
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
	public static void configureCustomers() {
		GetCustomersResponse getCustomersResponse = customerOrdersPortType.getCustomers(new GetCustomersRequest());
		AvailableCustomersManager.setAvailableCustomersList(getCustomersResponse.getCustomer());
	}
}

/*
This class uses the SOAP Web Service to get, from the Provider, the list of Customers available for the
Consumer server clients to select for an Order request.
After retrieving the Customers list, it is set as the availableCustomersList at the AvailableCustomersManager,
from where the Customers retrieved from the Provider, and now saved at the Consumer, can then be sent to 
populate the view HTML select options.  
*/
