package com.danielpm1982.SOAP_WS5.config;
import java.util.Arrays;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.SOAP_WS5.handlers.HeaderNodesHandler;
import com.danielpm1982.SOAP_WS5.ws.HelloWorldWSImpl;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new HelloWorldWSImpl());
		endpoint.publish("/HelloWorldService");
		SOAPBinding soapBinding = (SOAPBinding)endpoint.getBinding();
		soapBinding.setHandlerChain(Arrays.asList(new HeaderNodesHandler()));
		return endpoint;
	}
}

/*
A list of chain handlers must be set at the SOAPBinding of the EndPoint. It can have multiple handlers.
*/
