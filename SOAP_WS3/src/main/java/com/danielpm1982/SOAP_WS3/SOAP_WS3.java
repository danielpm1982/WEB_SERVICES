package com.danielpm1982.SOAP_WS3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SOAP_WS3 {
	public static void main(String[] args) {
		SpringApplication.run(SOAP_WS3.class, args);
	}
}

/*
This is the same WS1 project added CXF WS Security.
See config classes for comments.
All rest are the same.
For testing, a different xml envelope header should be used with the username and password. See the config 
classes for more.
Or, test it with the client class which generated the xml requests with the new header automatically as
manually configured there.
*/
