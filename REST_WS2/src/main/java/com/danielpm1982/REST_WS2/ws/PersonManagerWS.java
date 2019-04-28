package com.danielpm1982.REST_WS2.ws;
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
import com.danielpm1982.REST_WS2.model.Person;

@Consumes("application/xml, application/json")
@Produces("application/xml, application/json")
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
	@Path("/persons/truncateAndClearDB")
	@DELETE
	public abstract Boolean truncateAndClearDB();
}

/*
@Consumes and @Produces are set to add support for both xml and json format data types.
These annotations could also be set at each specific method if configuring them differently 
from one another would be of any use. For example, if one method would not consume or produce
JSON format messages - only XML, and another would consume and produce both. Here, the whole
interface is set equally. 
*/
