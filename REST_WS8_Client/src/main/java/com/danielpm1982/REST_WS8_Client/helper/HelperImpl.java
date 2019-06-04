package com.danielpm1982.REST_WS8_Client.helper;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS8_Client.model.Person;

@Service
public class HelperImpl implements Helper {
	private final String PERSONS_URL;
	public HelperImpl(@Value("${personURL}") String personsURL) {
		PERSONS_URL=personsURL;
	}
	@Override
	public List<Person> getPersonAll() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL);
		Builder invocationBuilder = target.request();
		List<Person> personList = invocationBuilder.get(new GenericType<List<Person>>(){});
		return personList;
	}
	@Override
	public Person getPersonUnique(long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL).path("/{id}").resolveTemplate("id", id);
		Builder invocationBuilder = target.request();
		Person person = invocationBuilder.get(Person.class);
		return person;
	}
	@Override
	public Person addPerson(Person person) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL);
		Builder invocationBuilder = target.request();
		Person addedPerson = invocationBuilder.post(Entity.entity(person, MediaType.APPLICATION_XML), Person.class);
		return addedPerson;
	}
	@Override
	public Person updatePerson(Person person) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL);
		Builder invocationBuilder = target.request();
		Person addedPerson = invocationBuilder.put(Entity.entity(person, MediaType.APPLICATION_XML), Person.class);
		return addedPerson;
	}
	@Override
	public boolean deletePerson(long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL).path("/{id}").resolveTemplate("id", id);
		Builder invocationBuilder = target.request();
		invocationBuilder.delete();
		return true;
	}
	@Override
	public boolean truncateAndClearDB() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PERSONS_URL).path("/truncateAndClearDB");
		Builder invocationBuilder = target.request();
		invocationBuilder.delete();
		return true;
	}
	@Override
	public String getPersonsURL() {
		return PERSONS_URL;
	}
}
