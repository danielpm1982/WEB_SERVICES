package com.danielpm1982.REST_WS1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS1 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS1.class, args);
	}
}

/*
This is a very basic REST WebService project which creates a PersonManager WebService (CRUD)
to manage a one entity bean called Person, with an id and name. The bean is annotated with JAXB
for serialization and deserialization, to and from XML (MIME type). The database is simulated
as a list (could also be a map) and all CRUD methods for the Person entity management are mapped 
to a certain Path Mapping and http method type using JAX-RS annotations. The client (browser) or 
consumer server simply calls that previously known endPoints, passing the path params and eventually
XML attatchments, and the REST server will manage to deal with the requests and send a response, 
also using XML. JSON and other MIME types are exemplified at later examples. The default is XML.
At the properties file, the property cxf.jaxrs.component-scan is set to true, so that cxf can look
for and find the interface and implementation of the service and publish it automatically to the
Consumer client to use through the endPoint http requests. This project can be tested by running
the server through the main class (REST_WS1) and by using Postman, and calling each endPoint method 
Path, with the params and xml attachments, as follows:

1. listing all Person available instances:
GET localhost:8080/REST_WS1/api/personManager/persons/

2. listing a unique Person instance:
GET localhost:8080/REST_WS1/api/personManager/persons/{id}

3. adding a unique Person instance:
POST localhost:8080/REST_WS1/api/personManager/persons/
(with the XML of the Person attached to the body of the http message:
<person>
    <name>personName1</name>
</person>
)

4. updating a unique Person instance:
PUT localhost:8080/REST_WS1/api/personManager/persons/
(with the XML of the Person attached to the body of the http message:
<person>
    <id>2</id>
    <name>personName2</name>
</person>
)

5. deleting a unique Person instance:
DELETE localhost:8080/REST_WS1/api/personManager/persons/{id}

These are the basic methods of the WS interface PersonManagerWS. See the interface, its Impl class
and the Person entity class for more comments and details.
*/
