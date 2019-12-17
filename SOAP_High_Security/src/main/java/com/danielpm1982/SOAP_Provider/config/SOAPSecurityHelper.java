package com.danielpm1982.SOAP_Provider.config;
import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SOAPSecurityHelper {
	public static void configureSecurity(Endpoint endpoint) {
		Map<String, Object> inProps = new HashMap<>();
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN+" "+ConfigurationConstants.ENCRYPT+" "+ConfigurationConstants.SIGNATURE+" "+ConfigurationConstants.TIMESTAMP);
		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		inProps.put(ConfigurationConstants.DEC_PROP_FILE, "etc/danielpm1982Store.properties");
		inProps.put(ConfigurationConstants.SIG_PROP_FILE, "etc/danielpm1982Store.properties");
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		((EndpointImpl)endpoint).getInInterceptors().add(wssIn); //downcasting is necessary for accessing the inner methods.
		Map<String, Object> outProps = new HashMap<>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP+" "+WSHandlerConstants.SIGNATURE+" "+WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		outProps.put(WSHandlerConstants.ENCRYPTION_USER, "soap_ws3_high_security_client_key");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE, "etc/danielpm1982Store.properties");
		outProps.put(WSHandlerConstants.ENCRYPTION_PARTS, "{Content}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Content}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.SIGNATURE_USER, "soap_ws3_high_security_key");
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "etc/danielpm1982Store.properties");
		outProps.put(WSHandlerConstants.SIGNATURE_PARTS, "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put("timeToLive", "10");
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		((EndpointImpl)endpoint).getOutInterceptors().add(wssOut); //downcasting is necessary for accessing the inner methods.
	}
}

/*
This class uses and configure the Apache WSS4J implementation of the SOAP WS-Security Standard on the received Apache EndpointImpl 
(configured, in turn, at WebServiceConfig.class), in order to guarantee the authentication (usernameToken), confidentiality (encryption), 
integrity (signature) and non-repudiation (timestamp) of the received and sent SOAP messages related to that implemented endpoint. 
*/
