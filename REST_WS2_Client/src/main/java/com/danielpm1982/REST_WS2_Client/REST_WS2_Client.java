package com.danielpm1982.REST_WS2_Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS2_Client {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS2_Client.class, args);
	}
}

/*
This is a Consumer Client Server which can be used to receive browser remote http calls to its local Controller,
use that calls together with the Helper local @Service class in order to, in turn, call the REST Provider Server,
receive the Provider response, and return, on the other hand, an html response to the browser that originally 
unleashed the first request.
The MIME type between the Consumer and Provider Servers is XML.
The complete flux is like below:
1.Browser --http GET/POST request--> 2.Consumer Server --XML/http--> 3.Provider Server --XML/http--> 
4.Consumer Server --HTML/http--> 5.Browser (final user).
This Consumer Server has been configured to be accessed through the 8181 port, as one must first start
the Provider Server at port 8080 before starting this Consumer Server, and test this through a browser.
The Provider Server can also be tested directly using Postman, instead of a Consumer Client Server, as this one.
For creating a Consumer Client Server, instead cxf-spring-boot-starter-jaxrs set of dependencies,
another dependencies set is needed: cxf-rt-rs-client (see the POM.xml file).
*/
