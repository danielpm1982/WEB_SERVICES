package com.danielpm1982.REST_WS8.config;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import com.danielpm1982.REST_WS8.ws.PersonResource;
 
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
        register(PersonResource.class);
    }
}
