package com.danielpm1982.REST_WS5.config;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource securityDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource); //if the default plain-text password encoder is used, use {noop}on the initial password value at the DB, e.g., {noop}123.
//		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder(12)).dataSource(securityDataSource); //if BcryptPasswordEncoder is used instead, use the value already encoded at the DB, e.g., $2a$12$lrYhYSLu0DAezMDW/l7xc.bNoctKPkn6zUE7hepP25xLNko4iS3j2 .
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
Authentication is set by overriding the configure(AuthenticationManagerBuilder auth) method 
of WebSecurityConfigurerAdapter, creating a users builder object with jdbcAuthentication, 
that will compare the user and password values sent by each user from the login page with 
the data (encrypted or not) that resides in the database (through the SecurityDataSource).
A SecurityDataSource bean is injected, after being created and have its dependencies injected, 
as defined at MyApplicationContextConfig class. This SecurityDataSource is passed as argument 
to the dataSource() method of the AuthenticationManagerBuilder auth object, so that all 
authentication now is done based on database and not more on memory stored user data as in the 
last project (REST_WS4). As for the second configure() method above, read the comments at
REST_WS4.
*/
