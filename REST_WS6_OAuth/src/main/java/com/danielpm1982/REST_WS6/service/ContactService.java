package com.danielpm1982.REST_WS6.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.danielpm1982.REST_WS6.dao.ContactDaoInterface;
import com.danielpm1982.REST_WS6.entity.Address;
import com.danielpm1982.REST_WS6.entity.Contact;
import com.danielpm1982.REST_WS6.entity.ContactModelAttribute;

@Service
public class ContactService implements ContactServiceInterface {
	@Autowired
	@Qualifier("contactDao")
	private ContactDaoInterface contactDaoInterface;
	@Override
	@Transactional
	public List<Contact> findContactAll() {
		return contactDaoInterface.findContactAll();
	}
	@Override
	@Transactional
	public Contact findByContactName(String contactName) {
		return contactDaoInterface.findContactByName(contactName);
	}
	@Override
	@Transactional
	public Contact findByContactId(long id) {
		return contactDaoInterface.findContactById(id);
	}
	@Override
	@Transactional
	public long save(ContactModelAttribute contactModelAttribute) {
		Address address = new Address(contactModelAttribute.getStreet(), contactModelAttribute.getNumber(), contactModelAttribute.getCity(), contactModelAttribute.getState(), contactModelAttribute.getCountry(), contactModelAttribute.getPostalCode());
		Contact contact = new Contact(contactModelAttribute.getName(), address, contactModelAttribute.getEmail(), contactModelAttribute.getPhoneNumber());
		return contactDaoInterface.save(contact);
	}
	@Override
	@Transactional
	public long save(Contact contact) {
		return contactDaoInterface.save(contact);
	}
	@Override
	@Transactional
	public boolean deleteContactById(Long contactId) {
		return contactDaoInterface.deleteContactById(contactId);
	}
	@Override
	@Transactional
	public boolean truncateAndClearAllContacts() {
		return contactDaoInterface.truncateAndClearAllContacts();
	}
}
