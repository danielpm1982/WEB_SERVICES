package com.danielpm1982.REST_WS6.ws;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS6.entity.Address;
import com.danielpm1982.REST_WS6.entity.Contact;
import com.danielpm1982.REST_WS6.service.ContactServiceInterface;

@Service
public class ContactManagerWSImpl implements ContactManagerWS{
	@Autowired
	@Qualifier("contactService")
	private ContactServiceInterface contactServiceInterface;
	public ContactManagerWSImpl() {
	}
	@PostConstruct
	private void init() {
		if(contactServiceInterface.findByContactId(1)==null) {
			addContact(new Contact(0, "contactName1", new Address("street1", 500, "city1", "state1", "country1", "50000-000"), "email1@email.com", "9999-9999", "555-5555"));
		}
	}
	@Override
	public List<Contact> getContactAll() {
		List<Contact> contactList = contactServiceInterface.findContactAll();
		if(contactList!=null&&!contactList.isEmpty()) {
			return contactList;
		} else {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Empty Client DB !\"}").type(MediaType.APPLICATION_JSON).build());
		}
	}
	@Override
	public Contact getContactUnique(long id){
		Contact contact = contactServiceInterface.findByContactId(id);
		if(contact!=null) {
			return contact;
		} else {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Getting failed ! No Contact found for the sent Id !\"}").type(MediaType.APPLICATION_JSON).build());
		}
	}
	@Override
	public Response addContact(Contact contact) {
		if(contactServiceInterface.findByContactName(contact.getName())!=null) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"Adding failed ! Contact already exists for that Contact name ! Contact not added !\"}").build();
		} else {
			long addedContactId = contactServiceInterface.save(contact);
			Contact addedContact = contactServiceInterface.findByContactId(addedContactId);
			if(addedContact!=null) {
				return Response.ok(addedContact).build();
			} else {
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"Adding failed ! Because of Unknown causes ! Contact not added !\"}").build();
			}
		}
	}
	@Override
	public Response updateContact(Contact contact) {
		Contact updatingContact = contactServiceInterface.findByContactId(contact.getId());
		if(updatingContact!=null) {
			updatingContact.setName(contact.getName());
			updatingContact.setAddress(contact.getAddress());
			updatingContact.setEmail(contact.getEmail());
			updatingContact.setPhoneNumber(contact.getPhoneNumber());
			long updatedContactId = contactServiceInterface.save(updatingContact);
			Contact updatedContact = contactServiceInterface.findByContactId(updatedContactId);
			return Response.ok(updatedContact).build();
		} else {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Update failed ! No Contact found for the sent Contact data (id) ! Contact not updated !\"}").type(MediaType.APPLICATION_JSON).build());
		}
	}
	@Override
	public Response deleteContact(long id) {
		Contact contact = contactServiceInterface.findByContactId(id);
		if(contact==null) {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Delete failed ! No Contact found for the sent Id ! Contact not deleted !\"}").type(MediaType.APPLICATION_JSON).build());
		} else {
			boolean deleted = contactServiceInterface.deleteContactById(id);
			return Response.ok(deleted).build();
		}
	}
	@Override
	public Response truncateAndClearDB() {
		boolean truncatedAndCleared = contactServiceInterface.truncateAndClearAllContacts();
		List<Contact> contactList = contactServiceInterface.findContactAll();
		if(contactList!=null&&contactList.size()==0&&truncatedAndCleared) {
			return Response.status(Status.OK).entity("{\"message\":"+"\"TruncateAndClearDB Successfull ! DB has been truncated and all its data deleted !\"}").build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"TruncateAndClearDB failed ! Because of Unknown causes !\"}").build();
		}
	}
}

/*
This is the webService interface implementing class, whose each method is associated with a REST endpoint 
published as this server REST API.
*/
