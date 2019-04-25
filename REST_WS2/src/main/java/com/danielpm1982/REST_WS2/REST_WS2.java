package com.danielpm1982.REST_WS2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS2 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS2.class, args);
	}
}

/*
This REST_WS2 project reuses most of the code from the REST_WS1 project, adding 3 basic features:
- JSON support (keeping XML support as well);
- Exception handling in multiple possible ways, when using JAX-RS API (including the return of JSON error messages);
- A Consumer Server Client implementation for testings (the tests could also keep being independently done using Postman).
For more comments on the implementation of the new features, look inside the ws folder content and also inside the 
exception package classes. Also, take a look at the POM.xml file, for the new added dependencies (jackson-jaxrs and 
jackson-xc) as well as at the properties file. And if you haven't read the comments of REST_WS1, take a look at them first. 
The comments there are not repeated here.

For adding JSON support, 3 things are needed:
- add the JSON dependencies - jackson-jaxrs and jackson-xc - at the POM.xml file;
- add two JAX-RS annotations (@Produces and @Consumes) at the service interface class (PersonManagerWS);
- set two properties at the prop file, namely cxf.jaxrs.classes-scan and cxf.jaxrs.classes-scan-packages, in place of
cxf.jaxrs.component-scan property.

For adding multiple types of Exception handling, only some new code is needed at the service implementing class 
(PersonManagerWSImpl), with the use of JAX-RS objects (as the generic WebApplicationException or some more specialized exceptions), 
and also, for custom handling, by using JAX-RS @Provider annotation, along with an ExceptionMapper interface implementation, 
for returning custom JSON messages inside the Response object. 
 
If we were already using @RestController at our provider service Controller, for letting the Spring API to deal with the bindings 
and with the marshalling/unmarshalling (serialization/deserialization) of responses/requests to and from JSON format, other 
approach could have been used for Exception handling, which is the use of Spring @ControllerAdvice and @ExceptionHandler annotations, 
along with ResponseEntity and other custom implemented error handling objects, as done at: 
https://github.com/danielpm1982/MAVEN/blob/master/Maven_Web_Spring_NoXML_REST_WS/src/main/java/com/danielpm1982/Maven_Web_Spring_NoXML_REST_WS/controller/MyWebServiceRESTControllerAdvice.java
.

For testing this project with Postman, using JSON messages, you have to set, at the header of the request, the Accept property as
Application/JSON, as well as set, at the request body, the content type that's gonna be sent as Application/JSON, as well. As configured
with the JAX_RS annotations @Produces and @Consumes, at the service interface class, this project does support both the sending of
XML and JSON request body content, as well as may return, according to the request header Accept property, XML or JSON responses. 
*/
