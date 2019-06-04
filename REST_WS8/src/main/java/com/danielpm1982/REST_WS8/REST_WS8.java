package com.danielpm1982.REST_WS8;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS8 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS8.class, args);
	}
}

/*
This is a sample and simple project showing how to use Jersey JAX-RS Framework instead of Apache CXF.
The REST_WS2 project has been adapted to use Jersey Framework and renamed here to REST_WS8.
The web interface interface has been excluded.
The POM has been changed and the app is configured at the properties file and at the JerseyConfig class, where each 
resource (webService interface) is added (in this case only one: PersonResource).
For testing, just run this main class and try the services with Postman, or use the client Consumer server (REST_WS8_Client).
For adapting from REST_WS2_Client to REST_WS8_Client, only the POM and the properties file have been changed, and
the jersey config class created. 
All jax-rs and jxb annotations, used to create the services, are the same.
For more comments see the original REST_WS2 and REST_WS2_Client projects.

The REST webService endpoints are: 

Get all Persons:
GET http://localhost:8080/REST_WS8/api/personManager/persons/

Get a Person with a specific id:
GET http://localhost:8080/REST_WS8/api/personManager/persons/{id}

Add a new Person:
POST http://localhost:8080/REST_WS8/api/personManager/persons/
body (e.g.):
{
    "id": 0,
    "name": "personName2"
}

Update an existing Person:
PUT http://localhost:8080/REST_WS8/api/personManager/persons/
body:
{
    "id": 1,
    "name": "personName100"
}

Delete an existing Person:
DELETE http://localhost:8080/REST_WS8/api/personManager/persons/1
*/
