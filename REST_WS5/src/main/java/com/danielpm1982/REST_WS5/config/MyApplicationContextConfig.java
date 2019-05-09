package com.danielpm1982.REST_WS5.config;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MyApplicationContextConfig implements WebMvcConfigurer{
	@Autowired
	private Environment environment;
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	private int getIntProperty(String propertyString) {
		return Integer.parseInt(environment.getProperty(propertyString));
	}
}

/*
This class creates the SecurityDataSource bean, to be injected and used at MyWebSecurityConfigurerAdapter class,
in order to storing and retrieving user data to/from databases (encrypted or not), instead of to/from program memory 
(in-memory authentication), as did at the REST_WS4 project. All the creation of databases and manipulation of 
auth user data are done by Spring, behind the scenes. The business data, though, will continue to be managed at
the web service implementing class in a List, that is, as an in-memory simulated database. Only the auth data
will now be managed with a real database connection, based on the SecurityDataSource above. 

The SecurityDataSource bean creator method is implemented with a ComboPooledDataSource being instantiated and set 
with the properties file values, regarding jdbc and connection pool configurations, and then has that object
returned as the created bean to be injected at the MyWebSecurityConfigurerAdapter class. This bean is used as an 
argument at the authentication configure method of this class class in order to send and retrieve registered user 
data to/from the database previously created, using in-built jdbc. 

Different (non-default) schemes or explicit jdbc/hibernate connection managing classes (DAOs) could also be used 
for that, what we're gonna do it at the next project (REST_WS6), where we'll use DAO/DAOService, DataSource, 
SessionFactory and TransactionManager, and some additional hibernate properties and dependencies, both for 
authentication as well as for logic business data storing at a DB.

For this project, sql script DB_Creation_SQL_Script must be run at the DBMS to create the scheme and populate it
with the default users (user1 - ROLE_USER and user2 - ROLE_ADMIN... for both the password is '123'). On next
projects there'll be complete UserService/DAO CRUD classes to do that in a manually customizable way.

See MyWebSecurityConfigurerAdapter for more comments.
*/
