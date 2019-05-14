package com.danielpm1982.REST_WS6.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS6.entity.Contact;
import com.danielpm1982.REST_WS6.entity.ContactModelAttribute;

@Service
public interface ContactServiceInterface {
	public abstract List<Contact> findContactAll();
	public abstract Contact findByContactName(String contactName);
    public abstract Contact findByContactId(long contactId);
    public abstract long save(ContactModelAttribute contactModelAttribute);
    public abstract long save(Contact contact);
    public abstract boolean deleteContactById(Long contactId);
    public abstract boolean truncateAndClearAllContacts();
}

/*
This is a custom Persistence @Service interface, that uses one or more injected DAOs, 
at its implementing class, to persist data at the DB (with TransactionManager, SessionFactory
and DataSource encapsulated underneath). It can be used anywhere at the application, including 
at the config classes, at the Controllers, at console standalone Main classes or at the REST 
webService implementing classes. It combines the Data Access layer of the application to the
Persistence Services it offers to other classes. 
*/
