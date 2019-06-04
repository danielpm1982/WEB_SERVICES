package com.danielpm1982.REST_WS8_Client.model;
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
