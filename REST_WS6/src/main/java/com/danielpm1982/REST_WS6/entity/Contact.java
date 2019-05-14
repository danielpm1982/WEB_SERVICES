package com.danielpm1982.REST_WS6.entity;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "contact", schema = "scheme1")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private Address address;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String[] phoneNumber;
	public Contact() {
	}
	public Contact(String name, Address address, String email, String... phoneNumber) {
		this(0, name, address, email, phoneNumber);
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
