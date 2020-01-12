package com.danielpm1982.REST_WS6.entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.danielpm1982.REST_WS6.validation.ValidEmail;

public class ContactModelAttribute {
	@NotNull(message = "name is required")
	@Size(min = 1, message = "name is required")
	private String name;
	@NotNull(message = "street is required")
	@Size(min = 1, message = "street is required")
	private String street;
	@NotNull(message = "number is required")
	@Min(value=1, message = "number is required")
	private int number;
	@NotNull(message = "city is required")
	@Size(min = 1, message = "city is required")
	private String city;
	@NotNull(message = "state is required")
	@Size(min = 1, message = "state is required")
	private String state;
	@NotNull(message = "country is required")
	@Size(min = 1, message = "country is required")
	private String country;
	@NotNull(message = "postalCode is required")
	@Size(min = 1, message = "postalCode is required")
	private String postalCode;
	@ValidEmail
	@NotNull(message = "email is required")
	@Size(min = 1, message = "email is required")
	private String email;
	@NotNull(message = "at least one phoneNumber is required")
	@Size(min = 1, message = "at least one phoneNumber is required")
	private String[] phoneNumber;
	public ContactModelAttribute() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}

/*
Although put in the entity package, this is not really a persistence class, but only a modelAttribute class which
receives the view field values in one single object (at each Spring form). This data is used at the Controller 
(if there were a view for managing contacts, not implemented here) and at the Persistence @Service beans, when 
they have to be sent to the DAO, using the real entities there instead (Address and Contact). At Spring forms we 
can use only one modelAttribute, which receives all form data and then have this data distributed to the Controller, 
Persistence Services and DAOs according to the more internal business logic.
This data is used at the management of Contacts, at the ContactService, which is used at the ws classes, for managing 
contacts through the Restful web services implemented here.
*/
