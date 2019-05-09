package com.danielpm1982.REST_WS5.ws;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS5.model.Address;
import com.danielpm1982.REST_WS5.model.Contact;

@Service
public class ContactManagerWSImpl implements ContactManagerWS{
	private long currentId;
	private List<Contact> contactsInMemoryDB;
	public ContactManagerWSImpl() {
		contactsInMemoryDB = new ArrayList<>();
		addContact(new Contact(0, "contactName1", new Address("street1", 500, "city1", "state1", "country1", "50000-000"), "email1@email.com", "9999-9999", "555-5555"));
	}
	@Override
	public List<Contact> getContactAll() {
		if(!contactsInMemoryDB.isEmpty()) {
			return contactsInMemoryDB;
		} else {
			throw new WebApplicationException(Status.NO_CONTENT);
		}
	}
	@Override
	public Contact getContactUnique(long id){
		Contact contact = contactsInMemoryDB.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		if(contact!=null) {
			return contact;
		} else {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Getting failed ! No Contact found for the sent Id !\"}").type(MediaType.APPLICATION_JSON).build());
		}
	}
	@Override
	public Response addContact(Contact contact) {
		contact.setId(++currentId);
		contactsInMemoryDB.add(contact);
		if(contactsInMemoryDB.contains(contact)) {
			return Response.ok(contact).build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"Adding failed ! Because of Unknown causes ! Contact not added !\"}").build();
		}
	}
	@Override
	public Response updateContact(Contact contact) {
		Contact updatingContact = contactsInMemoryDB.stream().filter(x->x.getId()==contact.getId()).findFirst().orElse(null);
		if(updatingContact!=null) {
			updatingContact.setName(contact.getName());
			return Response.ok(updatingContact).build();
		} else {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Update failed ! No Contact found for the sent Contact data ! Contact not updated !\"}").type(MediaType.APPLICATION_JSON).build());
		}
	}
	@Override
	public Response deleteContact(long id) {
		boolean removed = contactsInMemoryDB.removeIf(x->x.getId()==id);
		if(removed) {
			return Response.ok().build();
		} else {
			throw new NotFoundException(Response.status(Status.NOT_FOUND).entity("{\"message\":"+"\"Delete failed ! No Contact found for the sent Id ! Contact not deleted !\"}").type(MediaType.APPLICATION_JSON).build()); 
		}
	}
	@Override
	public Response truncateAndClearDB() {
		currentId=0;
		contactsInMemoryDB.clear();
		if(contactsInMemoryDB.size()==0) {
			return Response.status(Status.OK).entity("{\"message\":"+"\"TruncateAndClearDB Successfull ! DB has been truncated and all its data deleted !\"}").build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("{\"message\":"+"\"TruncateAndClearDB failed ! Because of Unknown causes !\"}").build();
		}
	}
}

//This is the webService interface implementing class, whose each method is associated with an endpoint 
//published for this server project REST API. As with later projects.
