package com.danielpm1982.SOAP_WS3.config;
import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.SOAP_WS3.ws.CustomerOrdersWSImpl;

@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWSImpl());
		endpoint.publish("/customerOrdersService");
		Map<String, Object> inProps = new HashMap<>();
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		((EndpointImpl)endpoint).getInInterceptors().add(wssIn); //downcasting is necessary for accessing the inner methods.
		return endpoint;
	}
}

//This is the publishing of the Endpoint of the webService along with its url
//and PortType implementation, so that it can be accessed from the consumer.
//WS CXF Security has been added to the endpoint.  

/*
At the webservice call, if SoapUI is to be used, without a Client Consumer server class,
the header of the envelope, in order to the call to be authenticated, should be:
 	<soapenv:Header>
	  <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" soapenv:mustUnderstand="1">
	  <wsse:UsernameToken xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
	  <wsse:Username xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">user</wsse:Username>
	  <wsse:Password xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">123</wsse:Password>
	  </wsse:UsernameToken>
	  </wsse:Security>
   </soapenv:Header>
At the username and password element value above, a valid username and password, contained for example at the manually 
implemented UTPasswordCallback class passwords list field, should be used. Otherwise a Security fault message will return.
*/
