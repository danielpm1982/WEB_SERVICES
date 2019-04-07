package com.danielpm1982.SOAP_WS2.config;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.SOAP_WS2.ws.AppointmentManager;
import com.danielpm1982.SOAP_WS2.ws.PersonManager;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new AppointmentManager());
		endpoint.publish("/appointmentService");
		return endpoint;
	}
	@Bean
	public Endpoint endpoint2() {
		Endpoint endpoint2 = new EndpointImpl(bus, new PersonManager());
		endpoint2.publish("/personService");
		return endpoint2;
	}
}
