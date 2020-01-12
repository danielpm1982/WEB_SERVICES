package com.danielpm1982.REST_WS6.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS6.entity.User;
import com.danielpm1982.REST_WS6.entity.UserModelAttribute;

@Service
public interface UserServiceInterface extends UserDetailsService {
    public abstract User findByUserName(String userName);
    public abstract void save(UserModelAttribute userModelAttribute);
    public abstract void deleteUserById(Long userId);
}

/*
This is a custom Persistence @Service interface, that uses one or more injected DAOs, 
at its implementing class, to persist data at the DB (with TransactionManager, SessionFactory
and DataSource encapsulated underneath). It can be used anywhere at the application, including 
at the config classes, at the Controllers, at console standalone Main classes or at the REST 
webService implementing classes. It combines the Data Access layer of the application to the
Persistence Services it offers to other classes. 
*/
