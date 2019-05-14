package com.danielpm1982.REST_WS6.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.danielpm1982.REST_WS6.entity.Contact;

@Repository
public class ContactDao implements ContactDaoInterface {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Contact> findContactAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<Contact> query = currentSession.createQuery("from Contact", Contact.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<>();
		}
	}
	@Override
	public Contact findContactByName(String contactName) {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<Contact> query = currentSession.createQuery("from Contact where name=:uName", Contact.class);
		query.setParameter("uName", contactName);
		try{
			return query.getSingleResult();
		} catch(NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Override
	public Contact findContactById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<Contact> query = currentSession.createQuery("from Contact where id=:uId", Contact.class);
		query.setParameter("uId", id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Override
	public long save(Contact contact) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(contact); //if new, save... if existing (same id), update.
		return contact.getId();
	}
	@Override
	public boolean deleteContactById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<Contact> query = currentSession.createQuery("from Contact where id=:uId", Contact.class);
		query.setParameter("uId", id);
		Contact deletingContact = null;
		try {
			deletingContact = query.getSingleResult();
			currentSession.remove(deletingContact);
			return true;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean truncateAndClearAllContacts() {
		Session currentSession = sessionFactory.getCurrentSession();
		try{
			currentSession.createNativeQuery("truncate table "+"scheme1.contact").executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
