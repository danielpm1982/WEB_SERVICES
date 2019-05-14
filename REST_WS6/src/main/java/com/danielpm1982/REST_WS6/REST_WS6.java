package com.danielpm1982.REST_WS6;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class REST_WS6 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS6.class, args);
	}
}

/*
Continuing the evolution from REST and SpringBoot Security projects REST_WS4 and REST_WS5, at this project REST_WS6 a custom 
ProviderAuthentication is be used, with BCrypt encoder/decoder, as well as with a UserService, injected with a full CRUD UserDAO 
with all methods needed for querying, creating, updating or deleting Users at the DB, using Hibernate. At the config classes, 
DataSource, SessionFactory and TransactionManager are configured, both for the persisting auth data as well as any other data 
at the same DB (in this case, the Contacts data), using the respective DAOs and Persistence Services. Also, a full CRUD view is 
created for the user to register at the server (DB) using a traditional web html view. Logical data (Contacts) also have a DAO/Service 
created for storing Contacts at the DB, instead of at in-memory List Collections, using the same data access layer and persistence
service used for auth data persistence. The persistence layers are used for both data types (auth and business).
For testing, run this Main class and use a browser or Postman for accessing the User CRUD or Contact CRUD interfaces. User CRUD
interface is accessible only through traditional web browser access, and Contact CRUD interface is accessible through both
the web html pages as well as from REST webService endPoints. In both cases, authentication and authorization rule the access.
The endPoints are generated from the Paths defined at the "ws" package, at the webService interface (ContactManagerWS). 
Please create and populate the DB before running this app, using the SQL script available at the "DB_Creation_SQL_Script" package.
Read the other classes' comments for more.
*/

/*
Json template for adding/updating a new registry at Postman:

{
    "id": 1,
    "name": "contact1",
    "address": {
        "street": "street1",
        "number": 1200,
        "city": "city1",
        "state": "state1",
        "country": "country1",
        "postalCode": "postalCode1"
    },
    "email": "email1",
    "phoneNumber": [
        "555-55-55",
        "8888-88-88"
    ]
}
*/
