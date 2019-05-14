package com.danielpm1982.REST_WS5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS5 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS5.class, args);
	}
}

/*
Similar to REST_WS4, but adding Spring/REST Security with jdbcAuthentication, instead of in-memory authentication.
New dependencies have been added (mysql-connector-java and c3p0).
Mysql and a real database is used here to store user auth data, but not yet business logic data (Contacts).
The user auth password data can be used as bcrypted values or plain-text (noop) ones.
A DataSource enterprise bean has been defined at MyApplicationContextConfig class for dealing with the connection 
and connection properties (from the properties file), and for being injected at the MyWebSecurityConfigurerAdapter
class, as an argument to the AuthenticationManagerBuilder auth, at the first configure method. At the second
configure method, HttpSecurity http is configured exactly the same as at the last project.
For more, see the config classes, the properties file and the POM file.
For testing, just run this Main class, after creating and populating the DB with the sql script DB_Creation_SQL_Script.sql
available at this project. Then use the web interface or Postman for testing the endpoints.
Next project (REST_WS6), a custom ProviderAuthentication will be used, with BCrypt encoder/decoder, as well as with
a UserService that will have a UserDAO injected with all CRUD methods available for creating, updating or deleting user 
auth data at the DB, using not only DataSource, but SessionFactory and TransactionManager with Hibernate/JPA framework, 
instead of implicit jdbcAuthentication as in this project. Also a full CRUD view will be created for the user to register at the
server (DB). And logical data (Contacts) will also have a DAO/Service created for storing Contacts at the DB, instead of at
in-memory List Collections. DataSource, SessionFactory and TransactionManager will be used for persisting both types of data 
(auth and business).
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