package com.danielpm1982.REST_WS1.ws;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS1.model.Person;

@Service
public class PersonManagerWSImpl implements PersonManagerWS{
	private long currentId;
	private List<Person> personsInMemoryDB;
	public PersonManagerWSImpl() {
		personsInMemoryDB = new ArrayList<>();
		addPerson(new Person(0, "personName1"));
	}
	@Override
	public List<Person> getPersonAll() {
		if(!personsInMemoryDB.isEmpty()) {
			return personsInMemoryDB;
		}
		return null;
	}
	@Override
	public Person getPersonUnique(long id) {
		return personsInMemoryDB.stream().filter(x->x.getId()==id).findFirst().orElse(null);
	}
	@Override
	public Response addPerson(Person person) {
		person.setId(++currentId);
		personsInMemoryDB.add(person);
		return Response.ok(person).build();
	}
	@Override
	public Response updatePerson(Person person) {
		Person updatingPerson = personsInMemoryDB.stream().filter(x->x.getId()==person.getId()).findFirst().orElse(null);
		updatingPerson.setName(person.getName());
		Person updatedPerson = personsInMemoryDB.stream().filter(x->x.getId()==person.getId()).findFirst().orElse(null);
		return Response.ok(updatedPerson).build();
	}
	@Override
	public Response deletePerson(long id) {
		boolean removed = personsInMemoryDB.removeIf(x->x.getId()==id);
		if(removed) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
}

/*
For this impl class of the custom Rest WebService interface, only the Spring @Service annotation is needed,
so that it is marked as a @Component to be scanned by the component-scanning of the cxf-jaxrs configured at
the properties file as true. JAX-RS annotations are done on its interface alone.
*/
