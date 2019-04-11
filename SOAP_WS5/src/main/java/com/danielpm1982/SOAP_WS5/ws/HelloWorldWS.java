package com.danielpm1982.SOAP_WS5.ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorldWS {
	@WebMethod
	public abstract String hello(@WebParam(name="userName") String userName);
}

//This is the interface of the PortType class annotated with JAX-WS.
