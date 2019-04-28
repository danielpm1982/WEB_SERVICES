package com.danielpm1982.REST_WS2_Client;
import com.danielpm1982.REST_WS2_Client.helper.Helper;
import com.danielpm1982.REST_WS2_Client.helper.HelperImpl;
import com.danielpm1982.REST_WS2_Client.model.Person;

public class TestHelper {
	private final static String PERSONS_URL = "http://localhost:8080/REST_WS2/api/personManager/persons";
	public static void main(String[] args) {
		Helper helper = new HelperImpl(PERSONS_URL);
		System.out.println("Truncating and clearing all Person database:");
		System.out.println(helper.truncateAndClearDB()?"Database cleared !":"Clearing failed !");
		System.out.println("Testing addPerson method:");
		System.out.println(helper.addPerson(new Person(0, "personName1")));
		System.out.println("Testing getPersonAll method:");
		helper.getPersonAll().forEach(System.out::println);
		System.out.println("Testing getPersonUnique method:");
		System.out.println(helper.getPersonUnique(1));
		System.out.println("Testing addPerson method:");
		System.out.println(helper.addPerson(new Person(0, "personName2")));
		System.out.println(helper.addPerson(new Person(0, "personName3")));
		System.out.println("Testing updatePerson method:");
		System.out.println(helper.updatePerson(new Person(1, "personName100")));
		System.out.println("Testing updatePerson method again:");
		System.out.println(helper.updatePerson(new Person(1, "personName1")));
		System.out.println("Testing deletePerson method:");
//		System.out.println(helper.deletePerson(1));
		System.out.println(helper.deletePerson(2));
		System.out.println(helper.deletePerson(3));
		System.out.println("Testing getPersonAll method:");
		if(helper.getPersonAll()!=null&&!helper.getPersonAll().isEmpty()) {
			helper.getPersonAll().forEach(System.out::println);
		} else {
			System.out.println("Person database is null or empty !");
		}
	}
}

/*
For testing the Helper class, just start the REST_WS2 Provider server, then run this standalone main class
as a Java Application.
*/
