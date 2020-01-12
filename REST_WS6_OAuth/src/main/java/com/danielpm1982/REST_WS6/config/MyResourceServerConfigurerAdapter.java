package com.danielpm1982.REST_WS6.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SuppressWarnings("deprecation")
@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter{
	private static final String RESOURCE_ID = "myResourceId";
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable()
		.httpBasic().and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/api/contactManager/contacts/**").hasRole("USER")
		.antMatchers("/api/contactManager/truncateAndClearDB/**").hasRole("ADMIN")
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}

/*
This class configures the resources being secured, including all protected endpoints, in the
case of this app, the /api endpoints, both for authenticated (with the OAuth2 valid token) as 
for certain roled Users. If authorization fails, access is denied.
*/

