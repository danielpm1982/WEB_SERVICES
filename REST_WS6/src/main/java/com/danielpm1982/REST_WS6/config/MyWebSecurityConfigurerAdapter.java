package com.danielpm1982.REST_WS6.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
    @Qualifier("userService")
    private UserServiceInterface userService;
	@Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable()
		.httpBasic().and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/api/contactManager/contacts/**").hasRole("USER")
		.antMatchers("/api/contactManager/truncateAndClearDB/**").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/loginResult").successHandler(myAuthenticationSuccessHandler).permitAll()
		.and()
		.logout().logoutSuccessHandler(myLogoutSuccessHandler).permitAll().and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
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
}

/*
This class configures the security for this app, both for web as for webService access,
including the User authentication and later authorization to every URI mapped resource.
By extending the WebSecurityConfigurerAdapter, it overrides the two configure() methods.
At the first, it uses the AuthenticationManagerBuilder argument object to set the type of
authentication, in this case, AuthenticationProvider type... and at the Provider bean
creation method, it sets, at a new instance of DaoAuthenticationProvider, the custom 
Persistence Service bean UserService (available at "service" package) as well as a
BCryptPasswordEncoder bean with a 14 encryption security strength. The Provider uses
the default method loadUserByUsername() from the UserDetailsService interface that
the custom UserService extends. Other classes of this app (the web Controller or webService
implementing classes, for instance) may use the UserService as well... in this app, the
registrationController does use all other UserService methods, not for authenticating (as 
the Provider does), but for CRUD managing User registrations. At the webService implementing
class, the userService bean is not needed (the contactService is the only Persistence Service 
bean which is used there), but eventually another REST webService interface and implementing 
class could be added for CRUD-dealing with User registries, instead of only traditional web 
Controllers. Both Persistence Service beans (UserService and ContactService) can be used
anywhere and at multiple places of the application, whenever Persistence of a User or Contact, 
respectively, is needed.   
At the second configure method, authorization is configured, as the credential ROLEs needed
for accessing some paths, and also the mapping Controller paths for the login, logout and
accessDenied pages. Success handlers of both login and logout are also set there.  
CRSF protection is disabled, for allowing post requests from Postman, and httpBasic 
authentication is turned on (must be used at Postman with a valid username and password for 
each http requests to be accepted). Other than the declarative security configured here, 
further authorization control is also used at the JSP pages, through Spring security taglibs 
(see welcome.jsp, for ex.).
OAuth or SSL are not used at this server application, although pretty important at real
servers.
*/
