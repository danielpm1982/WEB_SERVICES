package com.danielpm1982.REST_WS6.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception { //for being injected at MyAuthorizationServerConfigurerAdapter class
		return super.authenticationManagerBean();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService); //usable instead of the authenticationProvider below if no Encryption had to be used.
		auth.authenticationProvider(authenticationProvider());
	}
}

/*
This class basically configures the userService bean (UserService class) as the one to get the UserDetails from, in order to get the 
username, password and userRoles from the database and compare to the input username and password, for validation.
Also adds BCryption support, for automatically encrypting the input password and test if it matches the encrypted password at the database.
A DaoAuthenticationProvider is used and set to the AuthenticationManagerBuilder for that.  
Configuration of http is done at MyResourceServerConfigurerAdapter, specifically for each secured Resource (could have many).
*/

