package com.danielpm1982.REST_WS6.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import com.danielpm1982.REST_WS6.service.UserServiceInterface;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {
	private static final String RESOURCE_ID = "myResourceId";
	TokenStore tokenStore = new InMemoryTokenStore();
	@Autowired
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;
	@Autowired
	@Qualifier("userService")
	private UserServiceInterface userService;
	@Bean
	@Primary
	public DefaultTokenServices defaultTokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore);
		return defaultTokenServices;
	}
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager).userDetailsService(userService);
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("clientApp").authorizedGrantTypes("password", "refresh_token")
				.scopes("read", "write").secret("$2a$12$lrYhYSLu0DAezMDW/l7xc.bNoctKPkn6zUE7hepP25xLNko4iS3j2").resourceIds(RESOURCE_ID);
	}
}

/*
This class configures the AuthorizationServer for the OAuth token management. It configures the authorization endpoints,
setting a tokenStore, an authenticationManager and a userService... and also configures the clients that would be able
to ask authorization and a valid token for accessing the secured resources, with the clientName, the grantTypes, the scopes,
the secret and the resourceIds. By default, the endpoint for the client to get the token request to this AuthorizationServer
is http://localhost:8080/REST_WS6/oauth/token . User data (username and password) also should be sent to this server as part
of the authorization request data. See procedure at the printscreens folder at the resources package. With that token
in hand, the access to the secured resources, through this AuthorizationServer is guaranteed for that client app and registered
User. The secured Resources are set by using a RESOURCE_ID, both at this AuthorizationServer as at the ResourceServer, with the
same values (could be more than one). That RESOURCE_ID links this AuthorizationServer with the Resources being secured by it.
*/

