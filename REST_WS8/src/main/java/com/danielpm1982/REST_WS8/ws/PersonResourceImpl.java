package com.danielpm1982.REST_WS8.ws;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS8.exception.FailedToDeleteRuntimeException;
import com.danielpm1982.REST_WS8.model.Person;

@Service
public class PersonResourceImpl implements PersonResource{
	private long currentId;
	private List<Person> personsInMemoryDB;
	public PersonResourceImpl() {
		personsInMemoryDB = new ArrayList<>();
		addPerson(new Person(0, "personName1"));
	}
	@Override
	public List<Person> getPersonAll() {
		if(!personsInMemoryDB.isEmpty()) {
			return personsInMemoryDB;
		} else {
//			throw new WebApplicationException(Response.Status.NO_CONTENT); //Exception handling by throwing JAX-RS generic standard WebApplicationException(int Status)
			throw new WebApplicationException(Status.NO_CONTENT);
//			throw new WebApplicationException(204);
		}
	}
	@Override
	public Person getPersonUnique(long id){
		Person person = personsInMemoryDB.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		if(person!=null) {
			return person;
		} else {
//			throw new NotFoundException(); //Exception handling by throwing JAX-RS specific standard exception instead of the generic WebApplicationException(int status)
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"No Person found for the sent Id !\"}").type(MediaType.APPLICATION_JSON).build()); //the same as above, but including a Response with a JSON entity content within it (see ExceptionMapper class for details - there's another similar example there)
		}
	}
	@Override
	public Response addPerson(Person person) {
		person.setId(++currentId);
		personsInMemoryDB.add(person);
		if(personsInMemoryDB.contains(person)) {
			return Response.ok(person).build(); //Exception handling by returning JAX-RS Response object type with http response status with or without wrapped entity object inside
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"Adding failed because of unknown causes ! Person not added !\"}").build(); //Response with a JSON entity content within it (see ExceptionMapper class for details - there's another similar example there)
		}
	}
	@Override
	public Response updatePerson(Person person) {
		Person updatingPerson = personsInMemoryDB.stream().filter(x->x.getId()==person.getId()).findFirst().orElse(null);
		if(updatingPerson!=null) {
			updatingPerson.setName(person.getName());
			return Response.ok(updatingPerson).build();
		} else {
			throw new NotFoundException();
		}
	}
	@Override
	public Response deletePerson(long id) {
		boolean removed = personsInMemoryDB.removeIf(x->x.getId()==id);
		if(removed) {
			return Response.ok().build();
		} else {
			throw new FailedToDeleteRuntimeException("Delete failed ! No Person found for the requesting id !"); //Exception handling by using a custom runtime exception and handling this Exception at a custom Exception Mapper 
		}
	}
	@Override
	public Boolean truncateAndClearDB() {
		currentId=0;
		personsInMemoryDB.clear();
		if(personsInMemoryDB.size()==0) {
			return true;
		} else {
			return false;
		}
	}
}
