package com.danielpm1982.REST_WS8_Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS8_Client {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS8_Client.class, args);
	}
}

/*
This REST_WS8_Client is an adaptation of REST_WS2_Client for REST_WS8 (which is an adaptation of REST_WS2).
For using this client Consumer server, please start the server REST_WS8 first, which will turn available the 
REST webServices that this client application should access.
No jersey specific classes are used here, and the jersey springBoot starter dependency basically imports jax-rs 
dependencies, which are used to communicate with the Provider server through the helper class ... either via the 
console or web implemented interface.
For adapting from REST_WS2_Client to REST_WS8_Client, only the POM and the properties file have been changed.
The main objects at the client are: ClientBuilder, Client, WebTarget, InvocationBuilder.
For more comments see the original REST_WS2 and REST_WS2_Client projects.
*/
