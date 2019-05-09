package com.danielpm1982.REST_WS5.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	private String street;
	private int number;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	public Address() {
	}
	public Address(String street, int number, String city, String state, String country, String postalCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "street: "+street+", "+number+" city: "+city+" state: "+state+" country: "+country+" postalCode: "+postalCode;
	}
}
