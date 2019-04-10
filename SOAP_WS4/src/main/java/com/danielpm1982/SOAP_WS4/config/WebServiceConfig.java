package com.danielpm1982.SOAP_WS4.config;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.SOAP_WS4.ws.MTOMFileManagerWSImpl;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new MTOMFileManagerWSImpl());
		endpoint.publish("/MTOMFileManagerService");
		SOAPBinding soapBinding = (SOAPBinding)endpoint.getBinding();
		soapBinding.setMTOMEnabled(true);
		return endpoint;
	}
}

/*
This is the publishing of the Endpoint of the webService along with its url
and PortType implementation, so that it can be accessed from the consumer.
SoapBinding object from the Endpoint has been got in order to set MTOM enabled, 
which is false by default.
*/
