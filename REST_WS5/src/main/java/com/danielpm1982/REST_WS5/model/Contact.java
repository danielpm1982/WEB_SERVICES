package com.danielpm1982.REST_WS5.model;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
	private long id;
	private String name;
	private Address address;
	private String email;
	private String[] phoneNumber;
	public Contact() {
	}
	public Contact(long id, String name, Address address, String email, String... phoneNumber) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "id: "+id+" name: "+name+" address: "+address+" email: "+email+" phoneNumber: "+Arrays.asList(phoneNumber).stream().reduce("", (x,y)->x+" "+y);
	}
}
