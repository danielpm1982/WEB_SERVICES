package com.danielpm1982.SOAP_Consumer.helper;
import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import com.danielpm1982.customerorders.CustomerOrdersPortType;

public class SOAPSecurityHelper {
	public static void configureSecurity(CustomerOrdersPortType customerOrdersPortType) {
		Client client = ClientProxy.getClient(customerOrdersPortType);
		Endpoint endpoint = client.getEndpoint();
		Map<String, Object> outProps = new HashMap<>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN+" "+WSHandlerConstants.TIMESTAMP+" "+WSHandlerConstants.SIGNATURE+" "+WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.USER, "user");
		outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		outProps.put(WSHandlerConstants.ENCRYPTION_USER, "soap_ws3_high_security_key");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE, "etc/danielpm1982StoreClient.properties");
		outProps.put(WSHandlerConstants.ENCRYPTION_PARTS, "{Content}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Content}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}UsernameToken;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.SIGNATURE_USER, "soap_ws3_high_security_client_key");
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "etc/danielpm1982StoreClient.properties");
		outProps.put(WSHandlerConstants.SIGNATURE_PARTS, "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put("timeToLive", "10");
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		endpoint.getOutInterceptors().add(wssOut);
		Map<String, Object> inProps = new HashMap<>();
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.ENCRYPT+" "+ConfigurationConstants.SIGNATURE+" "+ConfigurationConstants.TIMESTAMP);
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		inProps.put(ConfigurationConstants.DEC_PROP_FILE, "etc/danielpm1982StoreClient.properties");
		inProps.put(ConfigurationConstants.SIG_PROP_FILE, "etc/danielpm1982StoreClient.properties");
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		endpoint.getInInterceptors().add(wssIn);
	}
}

/*
Similar to the SOAPSecurityHelper config class, at the Provider, this class configures and sets to the
Consumer side endpoint all security related to Authentication (usernameToken), Confidentiality (encryption),
Integrity (hash signatures) and non-repudiation of all SOAP messages being received from the Provider and 
being sent to the Provider. Some differences here are the USER, PASSWORD_TYPE and PW_CALLBACK_CLASS
that are used at the outProps, when which are not needed to be added at the corresponding outProps at the
Provider (this Consumer server messages must authenticate at the Provider, not otherwise). Also, the public
encryption key (ENCRYPTION_USER) for encryption and the private encryption key (SIGNATURE_USER) for the 
signature are switched, compared to the Provider similar class. The property 
org.apache.ws.security.crypto.merlin.keystore.alias=soap_ws3_high_security_client_key, at the local 
resources/etc/danielpm1982StoreClient.properties file, also has a different private key name for decryption
of messages - the private key here has a "client" at the name, as already said, regarding the hash signature
(both the decryption as the signature uses the same private local key, while the encryption uses the public
key from each other server). For more about the creation of the public and private keys, as well as keyStore,
for this Consumer server, see the keytoolProcess.zip file at the resources/keystore folder... which has all
console commands used for creating them for this server.
The Encryption and Signature parts also are different, as the in and out messages of both servers are a little
bit different in their elements. At the Provider, the out messages, as already said, do not contain the usernameToken,
for instance. Any non existent element of a SOAP message can't be marked for encryption or signature, at any server.
*/
