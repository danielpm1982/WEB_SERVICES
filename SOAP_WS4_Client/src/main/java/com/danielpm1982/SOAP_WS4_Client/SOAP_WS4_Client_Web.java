package com.danielpm1982.SOAP_WS4_Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_WS4_Client_Web {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_WS4_Client_Web.class, args);
	}
}

/*
This Consumer client project (SOAP_WS4_Client) consumes the WS-MTOM Standard file manager services 
available at the Provider server side (SOAP_WS4).
Either the Console or Web main classes can be used for testing.
Before running this Consumer client server please make sure that the Provider server is running as well.
More comments at the Provider server classes.
*/
