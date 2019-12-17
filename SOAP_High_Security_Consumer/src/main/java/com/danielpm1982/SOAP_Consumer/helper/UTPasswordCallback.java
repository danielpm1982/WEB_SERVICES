package com.danielpm1982.SOAP_Consumer.helper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler{
//	@Override
//	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
//		Arrays.asList(callbacks).stream().forEach(x->{
//			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback)x; //search the callback array for a WSPasswordCallback type object and downcast it
//			if(wsPasswordCallback.getIdentifier().equals("user")) { //search for an identifier equals to this client user username
//				wsPasswordCallback.setPassword("123"); //if found, set the WSPasswordCallback to the valid password of that user (set at the Provider server config classes).
//				return;
//			}
//		});
//	}
	private Map<String, String> passwords = new HashMap<>(); //in-memory list simulating a DB with identifiers and passwords
	public UTPasswordCallback() { //populating the identifiers and passwords
		passwords.put("user", "123");
		passwords.put("soap_ws3_high_security_client_key", "danielpm1982Password");
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
Similar to the same name class at the Provider server project, this class simply manages the passwords,
both of the user of this Consumer server as of the local private client encryption key, and delivers
these passwords to the security WSS4JInterceptors (in and out) when requested. The only difference is
that here the private key name has a "client" at it, differently from the private key at the Provider.
*/
