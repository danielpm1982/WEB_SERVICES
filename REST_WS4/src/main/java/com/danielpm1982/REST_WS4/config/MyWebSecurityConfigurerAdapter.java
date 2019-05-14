package com.danielpm1982.REST_WS4.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("user1").password("123").roles("USER"))
			.withUser(users.username("user2").password("123").roles("USER", "ADMIN"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable()
		.httpBasic().and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/loginPage").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/api/contactManager/contacts/**").hasRole("USER")
		.antMatchers("/api/contactManager/truncateAndClearDB/**").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/loginPage").loginProcessingUrl("/loginPageResult").defaultSuccessUrl("/welcome").and()
		.logout().permitAll().and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}

/*
This WebSecurityConfigurerAdapter child class configures basically the authentication (at the first configure() method,
and the authorization (at the second one).
As we're merely exemplifying a very poorly secured plain-text in-memory authentication, for individual users and their
respective usernames, passwords and roles, at the first method we just use the UserBuilder along with the 
auth.inMemoryAuthentication() method of the AuthenticationManagerBuilder. As the User auth data is neither persisted at a 
file nor at any database, every time the server restarts all user auth data, as well as the user business data (Contacts)
- which is also stored in a volatile List - is lost.
At projects REST_WS5 and REST_WS6 we use a much better design and implementation strategy that stores both the auth as well
as the business User data at a database and also encrypts the passwords with BCrypt algorithm. That's what would demand a 
real server application.     
Still regarding this demonstration project here, at the second configure() method we configure the authorizations for each
mapping path (including the REST API ones), define the login, logout and accessDenied pages, and also we set two very 
important properties in order for this project to work, which are: turning off the csrf - Cross-site request forgery, for 
Postman to be able to send POST requests to the server... and the setting of httpBasic authentication, which is the one
Postman will use to send user auth data and authenticate.  
In more advanced applications, OAuth 2.0 could be used for authentication/authorization, and would almost always definitely
be the safest option for both, instead of http basic authentication or the use of API keys.
*/
