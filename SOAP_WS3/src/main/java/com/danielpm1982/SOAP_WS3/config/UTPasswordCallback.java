package com.danielpm1982.SOAP_WS3.config;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler{
	private Map<String, String> passwords = new HashMap<>(); //in-memory list simulating a DB with identifiers and passwords
	public UTPasswordCallback() { //populating the identifiers and passwords
		passwords.put("admin", "admin");
		passwords.put("user", "123");
	}
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		Arrays.asList(callbacks).stream().forEach(x-> { //for each callback
			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback)x; //look for a WSPasswordCallback type object variable to downcast it
			String identifierCallback = wsPasswordCallback.getIdentifier(); //get the identifier
			String password = passwords.get(identifierCallback); //look at the "DB" for a password for that identifier
			if(password!=null) { //if Map registry exists for the identifier and password
				wsPasswordCallback.setPassword(password); //set the password to the WSPasswordCallback type callback and leave the iteration.
				return;
			}
		});
	}
}

/*
This is the UTPasswordCallback class that will be used as the value for the inProps PW_CALLBACK_CLASS property
at the WebServiceConfig class. At WebServiceConfig class, the inProps is then set at the WSS4JInInterceptor object, 
which is added to the inInterceptors at the publishing endPoint. When xml calls are to be sent to the webService,
a valid username and password, contained, in this case, at the list field above, should be used in order to the
sender to be authenticated and the operation to succeed. Otherwise a security fault message should return.
The username and password should be sent at the header of the envelope request call, which code is exemplified 
at the WebServiceConfig class comments. 
*/
