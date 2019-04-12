package com.danielpm1982.SOAP_WS5.ws;
import com.danielpm1982.SOAP_WS5.exceptions.InvalidNameException;

public class HelloWorldWSImpl implements HelloWorldWS{
	@Override
	public String hello(String name) throws InvalidNameException{
		if(name==null||name.equals("")||name.length()<5){
			throw new InvalidNameException(name);
		} else {
			return "Hello World "+name+" !!";
		}
	}
}

/*
This is the PortType class that will be set at the EndPoint and accessed by the user from the 
published WebService (see config class).
The user simply sends a hello with his name as the argument and the service answers with a String 
message containing that received client name.
The focus here is not the PortType class or any Stub Classes... only the handlers.
A bottom-up WebService development approach has been used at this project (code-first instead of wsdl-first).

A custom-created checked Exception type has been created and set to be thrown at the hello() method
to demonstrate the wsdl fault declaration (see the PortType element at the dynamically-generated wsdl) and
the XML response message with the fault body element containing the fault other elements: faultCode, 
faultString, faultActor and faultDetail. If the passed name is null or empty, or of a length smaller than
5, the response XML message will contain the error message of the checked Exception above.
If a Runtime exception had been used instead, then the error message would appear at the SOAP XML response,
but not at the dynamically-generated wsdl, and would be unknown to the Consumer class that would eventually
use that wsdl for creating a client class for the WebService. It can be tested with a SoapUI project using
the generated wsdl.
*/
