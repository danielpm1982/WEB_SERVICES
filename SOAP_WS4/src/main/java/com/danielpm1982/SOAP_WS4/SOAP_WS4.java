package com.danielpm1982.SOAP_WS4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_WS4 {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_WS4.class, args);
	}
}

/*
This project demonstrates the creation of a File Manager Server using WS-MTOM Standard.
A Consumer server (or SoapUI) sends an upload xml message, with a file of any type attached,
to the Provider server, and also can send a download xml message in order to receive the same
file, or any other, from the Provider. See other classes (PortType and config) comments 
and code for details.
*/
