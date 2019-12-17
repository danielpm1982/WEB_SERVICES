package com.danielpm1982.SOAP_Provider.config;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.SOAP_Provider.ws.CustomerOrdersWSImpl;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWSImpl());
		endpoint.publish("/customerOrdersService");
		SOAPSecurityHelper.configureSecurity(endpoint);
		return endpoint;
	}
}

/*
This is the publishing of the Endpoint of the Provider Web Service along with its url
and PortType implementation, so that it can be accessed from the consumer server side.
WS-Security Standard implementation has been added to the endpoint through the SOAPSecurityHelper 
class.
*/
