package com.danielpm1982.SOAP_Provider.config;
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
		passwords.put("user", "123");
		passwords.put("soap_ws3_high_security_key", "danielpm1982Password");
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
This UTPasswordCallback class stores, in memory, the usernames and passwords that are going to be used by
the in and out WSS4Jinterceptors at the SOAPSecurityHelper.class . Both relating to the usernameToken 
authentication as to the access to the private encryption key stored at the keyStore.
In the case of this application, it retrieves the passwords when called by the in and out WSS4JInterceptors.
In the case of the authentication process, for instance, the user password retrieved from this class is used by the 
inInterceptor to validate the incoming SOAP messages (whose user passwords are confronted to the passwords here retrieved), 
while the same password is used, by the outInterceptor, to set the password on the sending messages, which should be validated 
at the Consumer server side, likewise.
This class is almost identical to its counterpart class at the Consumer server, except for the private key password, which, 
there, is the soap_ws3_high_client_security_key , and not the provider private key as here.
*/
