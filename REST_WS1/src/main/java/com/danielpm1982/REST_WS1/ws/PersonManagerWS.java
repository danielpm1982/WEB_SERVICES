package com.danielpm1982.REST_WS1.ws;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.danielpm1982.REST_WS1.model.Person;

@Path("/personManager")
public interface PersonManagerWS {
	@Path("/persons")
	@GET
	public abstract List<Person> getPersonAll();
	@Path("/persons/{id}")
	@GET
	public abstract Person getPersonUnique(@PathParam("id") long id);
	@Path("/persons")
	@POST
	public abstract Response addPerson(Person person);
	@Path("/persons")
	@PUT
	public abstract Response updatePerson(Person person);
	@Path("/persons/{id}")
	@DELETE
	public abstract Response deletePerson(@PathParam("id") long id);
}

/*
This is the WebService interface that will have its service methods implemented by the Impl class.
This interface is annotated with JAX-RS annotations, basically @Path and @HttpMethodType and @PathParam 
for identifying the uri, http method and path params of the request and directing it to the appropriate 
service method. 
The Response object is used as response, with or without any object attached to it. The objects or primitives 
themselves can also be returned. 
As a default, XML is the chosen type for sending messages between a Consumer and Provider REST servers or 
client/server, although JSON, plainText and other MIME types can also be configured.
Although JAXB and JAX-RS annotations are used at these initial examples, more high level Spring annotations
as @RESTController, @HttpMethodTypeMapping, @RequestMapping, @PathVariable, @RequestBody, json automatic 
serialization/deserialization for responses and requests, data jpa repository interfaces extensions for 
auto-DAO and auto-Controller/Service creation, etc., could also be used. 
For this higher level Spring API with JSON see this other repository: https://github.com/danielpm1982/MAVEN .        
*/
