package com.danielpm1982.REST_WS6.dao;
import java.util.List;
import com.danielpm1982.REST_WS6.entity.Contact;

public interface ContactDaoInterface {
	public abstract List<Contact> findContactAll();
	public abstract Contact findContactByName(String contactName);
	public abstract Contact findContactById(long id);
	public abstract long save(Contact contact);
	public abstract boolean deleteContactById(long id);
	public abstract boolean truncateAndClearAllContacts();
}

/*could have used Spring Data automatic CRUD repositories generation 
by extending any extension of the Repository interface, for instance, 
org.springframework.data.jpa.repository.JpaRepository . And later adding
any custom method or implementation needed.*/
