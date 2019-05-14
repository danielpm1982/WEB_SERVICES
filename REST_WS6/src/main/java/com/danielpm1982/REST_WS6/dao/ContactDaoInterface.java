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
