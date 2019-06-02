package com.danielpm1982.REST_WS7;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS7 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS7.class, args);
	}
}

/*
This application exemplifies how to upload and download any type of file using CXF JAX-RS framework.
Both a Provider as well as a Consumer Server have been implemented, see comments about the Consumer
at the Consumer server classes.
This Provider REST Server basically implements a REST webService custom interface, with mapping paths
(and methods) for both uploading and downloding (see the ws folder classes for more comments).
For accessing this Provider REST service interface, a client Server has been implemented, as in later
projects, and all comments about it are within its own classes.
Any client of the Consumer Server (browser, smart tv, mobile phone, etc) can access this Provider
Server REST interface, uploading and downloading files.
The main objects at the Provider side are Attachment and Response, and the main ones at the Consumer side
are WebClient, ContentDisposition, Attachment and Response (see other classes of the Provider and 
Consumer servers for more).
No additional dependency is needed. All objects above are included at the CXF JAX-RS dependency at the
Provider as well as at the CXF Client at the Consumer.
A baseDestinationFilePathString property has been set at the properties file, which specifies the local
fileSystem path for saving uploaded files to this Provider server (from the Consumer server) and also 
for loading local files before sending them to the Consumer server, in order for them to be saved there.
Change the baseDestinationFilePathString for an existing path of your choice, at your own system, before 
testing this app.
*/
