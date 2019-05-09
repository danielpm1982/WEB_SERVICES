package com.danielpm1982.REST_WS5.ws;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.danielpm1982.REST_WS5.model.Contact;

@Consumes("application/xml, application/json")
@Produces("application/json")
@Path("/contactManager")
public interface ContactManagerWS {
	@Path("/contacts")
	@GET
	public abstract List<Contact> getContactAll();
	@Path("/contacts/{id}")
	@GET
	public abstract Contact getContactUnique(@PathParam("id") long id);
	@Path("/contacts")
	@POST
	public abstract Response addContact(Contact contact);
	@Path("/contacts")
	@PUT
	public abstract Response updateContact(Contact contact);
	@Path("/contacts/{id}")
	@DELETE
	public abstract Response deleteContact(@PathParam("id") long id);
	@Path("/truncateAndClearDB")
	@GET
	public abstract Response truncateAndClearDB();
}

/*
This is the REST WebService Interface, with JAX-RS annotations, which is implemented by
the implementation class, in turn, annotated with Spring @Service Annotation. JAXB annotations
are used at the entity classes (Contact and Address) this interface and its concrete class
use. Exactly as the other projects, REST_WS2 or REST_WS3.
*/
