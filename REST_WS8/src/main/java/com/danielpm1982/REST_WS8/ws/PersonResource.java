package com.danielpm1982.REST_WS8.ws;
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
import com.danielpm1982.REST_WS8.model.Person;

@Consumes("application/xml, application/json")
@Produces("application/json")
@Path("/personManager")
public interface PersonResource {
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
