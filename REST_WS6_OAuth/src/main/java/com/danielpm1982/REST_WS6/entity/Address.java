package com.danielpm1982.REST_WS6.entity;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Embeddable
public class Address {
	@Column(name = "street")
	private String street;
	@Column(name = "number")
	private int number;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "postal_code")
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
