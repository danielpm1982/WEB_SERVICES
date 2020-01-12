package com.danielpm1982.REST_WS6.dao;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.danielpm1982.REST_WS6.entity.User;

@Repository
public class UserDao implements UserDaoInterface {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public User findByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<User> query = currentSession.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		User user = null;
		try {
			user = query.getSingleResult();
			user.toString(); //for lazily loading the role table data before Session closes, avoiding errors.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	@Override
	public User findByUserId(Long userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<User> query = currentSession.createQuery("from User where id=:uId", User.class);
		query.setParameter("uId", userId);
		User user = null;
		try {
			user = query.getSingleResult();
			user.toString(); //for lazily loading the role table data before Session closes, avoiding errors.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user); //if new, save... if existing (same id), update.
	}
	@Override
	public void deleteUserById(Long userId) {
		User userToBeDeleted = findByUserId(userId);
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.remove(userToBeDeleted);
	}
}
