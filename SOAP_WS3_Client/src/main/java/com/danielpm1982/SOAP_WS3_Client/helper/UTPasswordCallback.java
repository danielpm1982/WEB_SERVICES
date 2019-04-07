package com.danielpm1982.SOAP_WS3_Client.helper;
import java.io.IOException;
import java.util.Arrays;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler{
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		Arrays.asList(callbacks).stream().forEach(x->{
			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback)x; //search the callback array for a WSPasswordCallback type object and downcast it
			if(wsPasswordCallback.getIdentifier().equals("user")) { //search for an identifier equals to this client user username
				wsPasswordCallback.setPassword("123"); //if found, set the WSPasswordCallback to the valid password of that user (set at the Provider server config classes).
				return;
			}
		});
	}
}
