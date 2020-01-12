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
ProviderAuthentication is used, with BCrypt encoder/decoder, as well as with a UserService, injected with a full CRUD UserDAO 
with all methods needed for querying, creating, updating or deleting Users at the DB, using Hibernate. At the config classes, 
DataSource, SessionFactory and TransactionManager are configured, both for the persisting auth data as well as for any other data 
at the same DB (in this case, the Contacts data), using the respective DAOs and Persistence Services. Also, a full CRUD view is 
created for the client to register new users at the server (DB) using a traditional web html view. Logical data (Contacts) also 
have a DAO/Service created for storing Contacts at the DB, instead of at in-memory List Collections, using the same data access 
layer and persistence service used for auth data persistence. The persistence layers are used for both data types (auth and business).
For testing, run this Main class and use a browser or Postman for accessing the User CRUD or Contact CRUD interfaces. User CRUD
interface is accessible only through traditional web browser access, and Contact CRUD interface is accessible through both
the web html pages (only GET requests) as well as from REST webService endPoints (full CRUD requests). In both cases, authentication 
and authorization rule the access, and all passwords stored at the Database are encrypted using BCrypt algorithm with strength 14.
The endPoints are generated from the Paths defined at the "ws" package, at the webService interface (ContactManagerWS). 
Please, create and populate the DB before running this app, using the SQL script available at the "DB_Creation_SQL_Script" package,
at the resources folder.
Additionally, at this extension of former REST_WS6 project, OAuth2.0 support has been added, and the user authentication is done
now through an OAuth token rather than through traditional username/password, at the user web view. For getting a valid token, though,
one should send a POST request to http://localhost:8080/REST_WS6/oauth/token (the default path for the AuthorizationServer), with
the required data, including the username/password for the app that will require the token to the Provider server,
as well as the username/password/grant_type/scopes for each authenticating user. This POST request for the token can be done using
either a client server or Postman (see printscreens of how and where to pass the fields/values at resources folder).
Other than some basic changes at the web view interface and Controllers, for using the token instead of username/password directly,
including the adding of a valid token at every GET request to a protected resource (access_token parameter), the main changes here 
are at the configuration classes, to which two other classes have been added: AuthorizationServerConfigurerAdapter and 
ResourceServerConfigurerAdapter. Also, the http configuration, that once was set at the WebSecurityConfigurerAdapter, now is 
set at the ResourceServer class (see the config package).
Read the other classes' comments for more.
*/

/*
Json template for posting/updating a new contact, using Postman, for instance:

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

This project and implementation has been fully designed and implemented by:

Daniel Pinheiro
danielpm1982.com
danielpm1982.com@domainsbyproxy.com

And is publicly available at my GitHub profile solely for studying purposes. 
*/
