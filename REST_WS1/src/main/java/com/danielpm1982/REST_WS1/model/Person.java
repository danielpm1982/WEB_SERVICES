package com.danielpm1982.REST_WS1.model;
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
This is a bean POJO class, used at the WebService implementation class, whose only JAXB annotation needed 
for serialization and deserialization (java->XML and XML->java) is the @XMLRootElement.   
*/
