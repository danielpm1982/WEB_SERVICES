package com.danielpm1982.REST_WS2_Client.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private long id;
	private String name;
	public Person() {
	}
	public Person(long id, String name) {
		this.id=id;
		this.name=name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "id: "+id+" name: "+name;
	}
}

/*
This is the same Entity java bean class to mount a person object each time a XML <-> java object deserialization
or serialization is needed. It must include the JAXB annotation at the top, as at the Provider.
*/
