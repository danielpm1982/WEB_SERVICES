package com.danielpm1982.REST_WS4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS4 {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS4.class, args);
	}
}

/*
Similar to REST_WS2, but adding (basic) Spring/REST Security (inMemoryAuthentication and custom authorizations 
for controller's mapping paths), for every username/password/role registered (individual passwords).
Alternatively, a single global password can also be created at runtime by springBoot if no @Configuration file is 
defined, only the spring-security dependency imported. The username would be 'user' and the password would be what 
appears at the console at the start time. A single global custom username and password can also be defined at the 
properties file, instead of using the springBoot auto-generated one. If the global password would be used, and not
the @Configuration file, then no Role selectiveness should be applied at the JSPs, as no User ROLEs would exist.
From these 3 approaches, the least worse is the one we use here, that is, the first one (see the config class), as
well as the dependencies imported (spring-boot-starter-security, spring-security-taglibs) and also the view, where 
we use spring security taglibs, for ex., when getting the Principal logged User data (security:authentication) or 
when selectively generating part of the html response from jsps according to the ROLE of the current authenticated 
user (security:authorize). ROLE_ADMIN will have more privileges (options of REST endpoints to see and call) than 
ROLE_USER. If an authenticated unauthorized user calls an endpoint he doesn't have sufficient privileges to use,
an accessDeniedPage would appear. Also, a custom login page, with custom logout and error pages have been developed.  
See MySecurityWebConfigurerAdapter.java class for more comments on the configuration of authentication as well as 
authorization.
For User Data to be stored at a DB, and for managing Users through UserDAOs and UserServices, as well as for
encryption, see REST_WS5 (JDBC) and REST_WS6 (Hibernate) projects. REST_WS6 would be the best advanced option
for security regarding Spring5/Springboot2 and REST WebServices.
The symbolic business logic at the project, which will be reused for the REST_WS5 and REST_WS6 projects, is the
managing of Contacts with Addresses, and some other fields. Both entity classes are marked with @XMLRootElement
annotations. It's a simple UML aggregation between the Contact (whole) object and Address (part) object.
This app can be partially tested using the web interface of this same project, or completely tested using Postman.
For authentication at Postman, use the Authorization Basic Auth. And Json or XML at the body of the message when
necessary (POST and PUT requests). 
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