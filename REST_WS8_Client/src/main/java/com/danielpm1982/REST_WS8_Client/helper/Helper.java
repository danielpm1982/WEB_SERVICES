package com.danielpm1982.REST_WS8_Client.helper;
import java.util.List;
import com.danielpm1982.REST_WS8_Client.model.Person;

public interface Helper {
	public abstract List<Person> getPersonAll();
	public abstract Person getPersonUnique(long id);
	public abstract Person addPerson(Person person);
	public abstract Person updatePerson(Person person);
	public abstract boolean deletePerson(long id);
	public boolean truncateAndClearDB();
	public String getPersonsURL();
}
