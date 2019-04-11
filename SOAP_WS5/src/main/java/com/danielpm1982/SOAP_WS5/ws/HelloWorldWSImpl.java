package com.danielpm1982.SOAP_WS5.ws;

public class HelloWorldWSImpl implements HelloWorldWS{
	@Override
	public String hello(String userName) {
		return "Hello World "+userName+" !!";
	}
}

/*
This is the PortType class that will be set at the EndPoint and accessed by the user from the 
published WebService (see config class).
The user simply sends a hello with his name as the argument and the service answers with a String 
message containing that received client name.
The focus here is not the PortType class or any Stub Classes... only the handlers.
A bottom-up WebService development approach has been used at this project (code-first instead of wsdl-first).
*/
